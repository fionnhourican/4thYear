import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * This class implements RSA key generation, digital signing, and signature
 * verification.
 */
public class Assignment2 {

    /**
     * Main method to run the RSA signature generation and verification.
     * 
     * @param args Command-line arguments, expects a filename for reading input
     *             data.
     */
    private static final int BIT_LENGTH = 512;
    private static final SecureRandom random = new SecureRandom();
    private static final BigInteger E = BigInteger.valueOf(65537);

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Assignment2 <filename>");
            return;
        }

        // Test with small values
        // testWithSmallValues();

        String filename = args[0];

        // Generate large primes and calculate n and phi
        BigInteger p, q, n, phi, d;
        do {
            p = generatePrime();
            q = generatePrime();
            // Used this to ensure p & q distinct
            while (p.equals(q)) {
                q = generatePrime();
            }
            n = calculateProduct(p, q);
            phi = calculatePhi(p, q);
        } while (!isRelativelyPrime(E, phi)); // Used to ensure e relatively prime to phi(n)

        d = computeDecryptionExponent(E, phi);

        // Output the modulus to Modulus.txt
        try {
            Files.write(Paths.get("Modulus.txt"), n.toString(16).getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        /*
         * System.out.println("Prime p: " + p.toString(16));
         * System.out.println("Prime q: " + q.toString(16));
         * System.out.println("Product n: " + n.toString(16));
         * System.out.println("Euler's Totient phi(n): " + phi.toString(16));
         * System.out.println("Encryption exponent e: " + E.toString(16));
         * System.out.println("Decryption exponent d: " + d.toString(16));
         */

        // Test decryption with small values
        // testDecryptionWithSmallValues(p, q, n, d);

        // Read the input file and generate its SHA-256 digest
        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(filename));
            byte[] digest = generateSHA256Digest(fileContent);
            BigInteger signature = signDigest(digest, d, n);
            System.out.println(signature.toString(16));

            // Verify the signature
            /*
             * boolean isVerified = verifySignature(digest, signature, E, n);
             * System.out.println("Signature verification: " + isVerified);
             */
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate a 512-bit probable prime.
     * 
     * @return A 512-bit probable prime.
     */
    public static BigInteger generatePrime() {
        return new BigInteger(BIT_LENGTH, 100, random);
    }

    /**
     * Calculate the product of these two primes n = pq.
     * 
     * @param p The first prime.
     * @param q The second prime.
     * @return The product of p and q.
     */
    public static BigInteger calculateProduct(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }

    /**
     * Calculate the Euler totient function phi(n).
     * @param p The first prime.
     * @param q The second prime.
     * @return The Euler totient function phi(n).
     */
    public static BigInteger calculatePhi(BigInteger p, BigInteger q) {
        return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }

    /**
     * Ensure that e is relatively prime to phi(n).
     * @param e The encryption exponent.
     * @param phi The Euler totient function phi(n).
     * @return True if e is relatively prime to phi(n), false otherwise.
     */
    public static boolean isRelativelyPrime(BigInteger e, BigInteger phi) {
        return e.gcd(phi).equals(BigInteger.ONE);
    }

    /**
     * Compute the value for the decryption exponent d.
     * @param e The encryption exponent.
     * @param phi The Euler totient function phi(n).
     * @return The decryption exponent d.
     */
    public static BigInteger computeDecryptionExponent(BigInteger e, BigInteger phi) {
        return extendedEuclideanGCD(e, phi)[1].mod(phi);
    }

    /**
     * Extended Euclidean GCD algorithm to calculate the inverse.
     * This function was based on the notes and also the following source:
     * https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/
     * @param a The first number.
     * @param b The second number.
     * @return An array containing the GCD and the coefficients of the Bézout's identity.
     */
    public static BigInteger[] extendedEuclideanGCD(BigInteger a, BigInteger b) {
        BigInteger x0 = BigInteger.ONE, x1 = BigInteger.ZERO;
        BigInteger y0 = BigInteger.ZERO, y1 = BigInteger.ONE;
        BigInteger q, temp;
        while (!b.equals(BigInteger.ZERO)) {
            q = a.divide(b);
            temp = a;
            a = b;
            b = temp.mod(b);

            temp = x0;
            x0 = x1;
            x1 = temp.subtract(q.multiply(x1));

            temp = y0;
            y0 = y1;
            y1 = temp.subtract(q.multiply(y1));
        }
        return new BigInteger[] { a, x0, y0 }; // gcd, x, y
    }

    /**
     * Decryption method which calculates h(m)^d (mod n) using CRT.
     * @param h The encrypted message.
     * @param d The decryption exponent.
     * @param p The first prime.
     * @param q The second prime.
     * @return The decrypted message.
     */
    public static BigInteger decrypt(BigInteger h, BigInteger d, BigInteger p, BigInteger q) {
        BigInteger dp = d.mod(p.subtract(BigInteger.ONE));
        BigInteger dq = d.mod(q.subtract(BigInteger.ONE));
        BigInteger qInv = extendedEuclideanGCD(q, p)[1].mod(p);

        BigInteger m1 = h.modPow(dp, p);
        BigInteger m2 = h.modPow(dq, q);

        BigInteger hMod = m1.subtract(m2).multiply(qInv).mod(p).multiply(q).add(m2);
        return hMod;
    }

    /**
     * Test decryption with small values.
     * @param p The first prime.
     * @param q The second prime.
     * @param n The product of p and q.
     * @param d The decryption exponent.
     */
    public static void testDecryptionWithSmallValues(BigInteger p, BigInteger q, BigInteger n, BigInteger d) {
        BigInteger h = BigInteger.valueOf(42); // Example message digest

        // Encrypt the message digest using the public key (e, n)
        BigInteger encrypted = h.modPow(E, n);

        // Decrypt the encrypted message using the private key (d, p, q)
        BigInteger decrypted = decrypt(encrypted, d, p, q);

        System.out.println("Test decryption with small values:");
        System.out.println("Message digest h: " + h);
        System.out.println("Encrypted message: " + encrypted);
        System.out.println("Decrypted message: " + decrypted);
        System.out.println("Decryption is correct: " + h.equals(decrypted));
        System.out.println();
    }

    /**
     * Test with small values for p, q, n, phi.
     */
    public static void testWithSmallValues() {
        BigInteger p = BigInteger.valueOf(11);
        BigInteger q = BigInteger.valueOf(13);
        BigInteger n = calculateProduct(p, q);
        BigInteger phi = calculatePhi(p, q);
        boolean relativelyPrime = isRelativelyPrime(E, phi);
        BigInteger d = computeDecryptionExponent(E, phi);

        System.out.println("Test with small values:");
        System.out.println("Prime p: " + p); // Expected: 11
        System.out.println("Prime q: " + q); // Expected: 13
        System.out.println("Product n: " + n); // Expected: 143
        System.out.println("Euler's Totient phi(n): " + phi); // Expected: 120
        System.out.println("Is e relatively prime to phi(n): " + relativelyPrime); // Expected: true
        System.out.println("Decryption exponent d: " + d); // Expected: 113
        System.out.println();
    }

    /**
     * Generate SHA-256 digest of an input binary file.
     * @param input The input binary file.
     * @return The SHA-256 digest.
     * @throws NoSuchAlgorithmException If the SHA-256 algorithm is not available.
     */
    public static byte[] generateSHA256Digest(byte[] input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(input);
    }

    /**
     * Digitally sign the digest of an input binary file.
     * @param digest The SHA-256 digest.
     * @param d The decryption exponent.
     * @param n The product of the primes.
     * @return The digital signature.
     */
    public static BigInteger signDigest(byte[] digest, BigInteger d, BigInteger n) {
        BigInteger h = new BigInteger(1, digest); // Convert digest to BigInteger
        return h.modPow(d, n); // Sign the digest using the private key (d, n)
    }

    /**
     * Verify the signature.
     * @param digest The SHA-256 digest.
     * @param signature The digital signature.
     * @param e The encryption exponent.
     * @param n The product of the primes.
     * @return True if the signature is valid, false otherwise.
     */
    public static boolean verifySignature(byte[] digest, BigInteger signature, BigInteger e, BigInteger n) {
        BigInteger h = new BigInteger(1, digest); // Convert digest to BigInteger
        BigInteger decryptedSignature = signature.modPow(e, n); // Decrypt the signature using the public key (e, n)
        return h.equals(decryptedSignature); // Compare the decrypted signature with the original digest
    }

    /**
     * Helper method to convert BigInteger to byte array correctly.
     * @param bigInt The BigInteger to convert.
     * @return The byte array representation of the BigInteger.
     */
    public static byte[] toByteArray(BigInteger bigInt) {
        byte[] byteArray = bigInt.toByteArray();
        if (byteArray[0] == 0) {
            byte[] tmp = new byte[byteArray.length - 1];
            System.arraycopy(byteArray, 1, tmp, 0, tmp.length);
            return tmp;
        }
        return byteArray;
    }
}
