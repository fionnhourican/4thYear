import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * This class implements the first assignment, using the values created from the
 * GenerateIv and DiffieHellmanKeyExchange Class.
 * It adds padding to the plaintext and encrypts the plaintext using AES in CBC
 * mode.
 */
public class Assignment1 {

    /**
     * Private key used in the encryption process, generted by
     * DiffieHellmanKeyExchange class.
     */
    static BigInteger privatekey = new BigInteger("a8ee1262e00b3e4d146650f56a0e241d6c576238daacaa8f2fafc7c05762a6f2",
            16);

    /** File name for the DH value, generted by DiffieHellmanKeyExchange class. */
    static String dhFile = "DH.txt";

    /** File name for the IV value generted by GenerateIv class. */
    static String ivFile = "IV.txt";

    /** Diffie-Hellman value, to be read from the DH.txt file. */
    static BigInteger dhValue;

    /** Initialization vector (IV) value, to be read from the IV.txt file. */
    static BigInteger ivValue;

    /**
     * Main method that orchestrates reading the files, padding the plaintext, and
     * encrypting
     * it using AES in CBC mode.
     *
     * @param args Command-line arguments. Expects the input plaintext file as an
     *             argument.
     * @throws Exception If any errors occur during file reading or encryption.
     */
    public static void main(String[] args) throws Exception {
        try {
            // Read the DH.txt file
            String dhHexValue = readFile(dhFile);
            BigInteger dhValue = new BigInteger(dhHexValue, 16);

            String ivHexValue = readFile(ivFile);
            BigInteger ivValue = new BigInteger(ivHexValue, 16);

            // Check if the input file is provided, this is the plaintext
            if (args.length < 1) {
                System.out.println("Usage: java Assignment1 <inputFile>");
                return;
            }

            // Convert the plaintext from the file to a byte array
            byte[] hexPlaintext = readAndConvertToByteArray(args[0]);

            // Add Pading to the plaintext
            byte[] paddedPlaintext = Padding.ApplyPadding(hexPlaintext);

            // Prepare AES key and IV for encryption by converting to byte arrays
            byte[] aesKey = Arrays.copyOf(privatekey.toByteArray(), 16); // Make sure key is 16 bytes
            byte[] iv = Arrays.copyOf(ivValue.toByteArray(), 16); // Make sure IV is 16 bytes

            // Perform AES encryption with CBC mode
            byte[] ciphertext = aesEncrypt(paddedPlaintext, aesKey, iv);
            System.out.println(toHex(ciphertext));

            // To test it I tried to Decrypt the ciphertext
            // DecryptionTest.testDecryption(ciphertext, aesKey, iv);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts a BigInteger to a hexadecimal string.
     *
     * @param num The BigInteger to be converted.
     * @return Hexadecimal representation of the BigInteger.
     */
    public static String toHex(BigInteger num) {
        return num.toString(16);
    }

    /**
     * Converts a byte array to a hexadecimal string.
     *
     * @param data The byte array to be converted.
     * @return Hexadecimal representation of the byte array.
     */
    public static String toHex(byte[] data) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : data) {
            hexString.append(String.format("%02x", b)); // Format each byte as hex
        }
        return hexString.toString();
    }

    /**
     * Reads the content of a plaintext file and converts it to a byte array.
     *
     * @param inputFile The file containing the plaintext.
     * @return The byte array representation of the plaintext.
     * @throws IOException If an error occurs during file reading.
     */
    public static byte[] readAndConvertToByteArray(String inputFile) throws IOException {
        // Read the plaintext from the input file
        String plaintext = readFile(inputFile);

        // Convert plaintext to bytes
        byte[] plaintextBytes = plaintext.getBytes();

        return plaintextBytes;
    }

    /**
     * Reads a file and returns its content as a string.
     *
     * @param filename The name of the file to be read.
     * @return The file content as a string.
     * @throws IOException If an error occurs during file reading.
     */
    private static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line.trim()); // Append each line to the content
            }
        }
        return content.toString();
    }

    /**
     * Encrypts the given plaintext using AES in CBC mode with no padding.
     *
     * @param plaintext The plaintext byte array to encrypt.
     * @param key       The AES key, must be 16 bytes.
     * @param iv        The initialization vector (IV) for CBC mode, must be 16
     *                  bytes.
     * @return The encrypted ciphertext as a byte array.
     * @throws Exception If any error occurs during the encryption process.
     */
    public static byte[] aesEncrypt(byte[] plaintext, byte[] key, byte[] iv) throws Exception {
        // Create a new AES key using the key generated from our shared secret
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

        // Create a Cipher instance for AES in CBC mode with NoPadding
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");

        // Initialize the cipher with the AES key and IV
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        // Perform the encryption
        return cipher.doFinal(plaintext);
    }
}

/**
 * The {@code Padding} class provides methods for applying and removing padding
 * to a block of data according to the custom padding scheme. Adding a 1-bit
 * followed by a number of 0-bits. This padding ensuresthe data fits exactly
 * into blocks of a specified size (128 bits = 16 bytes).
 */
class Padding {
    // Constants
    private static final int BLOCK_SIZE_BYTES = 16; // 128 bits = 16 bytes

    /**
     * Applies padding to the given byte array so that its size becomes a multiple
     * of the block size (16 bytes). It pads using a 1-bit followed by 0-bits.
     *
     * @param data the byte array to which padding needs to be applied
     * @return a new byte array with padding added to fit into a block size of 16
     *         bytes
     */
    public static byte[] ApplyPadding(byte[] data) {
        int dataLength = data.length;
        int remainder = dataLength % BLOCK_SIZE_BYTES;

        // If the data length is exactly the block size, add an extra padded block
        if (remainder == 0) {
            return padExtraBlock(data);
        }

        // If the data is less than the block size, pad with 1-bit and 0-bits
        return padToFillBlock(data, remainder);
    }

    /**
     * Adds padding to fill the remaining space in the block. The method pads
     * the given byte array with a 1-bit followed by 0-bits to fit the block size.
     *
     * @param data      the original byte array to be padded
     * @param remainder the number of remaining bytes that need to be filled to
     *                  match the block size
     * @return a new byte array with padding applied to fill the block size
     */
    public static byte[] padToFillBlock(byte[] data, int remainder) {
        // New array of size current Array + remainder to fill block
        int bitsToPad = BLOCK_SIZE_BYTES - remainder;
        byte[] paddedData = new byte[data.length + bitsToPad];

        // Copy original data to new array
        System.arraycopy(data, 0, paddedData, 0, data.length);

        // 1-bit in the first position of the new block
        paddedData[data.length] = (byte) 0x80;

        return paddedData;
    }

    /**
     * Pads an extra block to the data if its length is already a multiple of
     * the block size. This ensures that even data that fits perfectly into blocks
     * is padded with an additional block.
     *
     * @param data the original byte array that already matches the block size
     * @return a new byte array with an extra block padded
     */
    public static byte[] padExtraBlock(byte[] data) {
        // New array of size current Array + new block
        byte[] paddedData = new byte[data.length + BLOCK_SIZE_BYTES];

        // Copy original data to new array
        System.arraycopy(data, 0, paddedData, 0, data.length);

        // 1-bit in the first position of the new block
        paddedData[data.length] = (byte) 0x80;

        return paddedData;
    }

    /**
     * Removes padding from the given byte array. Removes trailing 0-bits until the
     * 1-bit is reached
     *
     * @param paddedData the padded byte array from which padding needs to be
     *                   removed
     * @return the original byte array with padding removed
     */
    public static byte[] removePadding(byte[] paddedData) {
        int i = paddedData.length - 1;

        // Travrse from the end to find the 0x80 byte
        while (i >= 0 && paddedData[i] == 0x00) {
            i--;
        }

        // If 0x80 is found, that marks the end of the original data
        if (i >= 0 && paddedData[i] == (byte) 0x80) {
            // Create a new array with padding removed
            byte[] unpaddedData = new byte[i];
            System.arraycopy(paddedData, 0, unpaddedData, 0, i);
            return unpaddedData;
        }

        // If padding was not found, return the original array
        return paddedData;
    }
}

/**
 * The {@code DecryptionTest} class is used to decrypt the ciphertext.
 * I used this to test my encryption. It should be easy to reverse if It worked.
 * This class provides a method to decrypt ciphertext using AES in CBC mode with
 * a given key and IV.
 */
class DecryptionTest {

    /**
     * Tests the decryption of the given ciphertext using the provided AES key and
     * IV.
     * Prints the decrypted text in hexadecimal format.
     *
     * @param ciphertext the encrypted data to be decrypted
     * @param key        the AES key used for decryption
     * @param iv         the initialization vector (IV) used for CBC mode decryption
     */
    public static void testDecryption(byte[] ciphertext, byte[] key, byte[] iv) {
        try {
            // Decrypt the ciphertext
            byte[] decryptedText = aesDecrypt(ciphertext, key, iv);
            System.out.println("Decrypted Text in Hex: " + Assignment1.toHex(decryptedText));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Decrypts the given ciphertext using AES with CBC mode and no padding.
     * The AES key and IV must be provided for proper decryption.
     *
     * @param ciphertext the encrypted data to be decrypted
     * @param key        the AES key used for decryption
     * @param iv         the initialization vector (IV) used for CBC mode decryption
     * @return the decrypted data after removing the applied padding
     * @throws Exception if any error occurs during decryption
     */
    private static byte[] aesDecrypt(byte[] ciphertext, byte[] key, byte[] iv) throws Exception {
        // Create a SecretKeySpec for the AES key
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

        // Create a Cipher instance for AES in CBC mode with NoPadding
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");

        // Initialize the cipher with the AES key and IV
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        // Perform the decryption and remove the padding
        byte[] decrypted = cipher.doFinal(ciphertext);
        return Padding.removePadding(decrypted);
    }
}

/**
 * The {@code ModularExponentiation} class performs modular exponentiation.
 * This class provides a method to efficiently compute large powers modulo a
 * given number.
 */
class ModularExponentiation {

    /**
     * Computes (base^exponent) % modulus using an efficient iterative method.
     * This method uses the square-and-multiply technique for modular
     * exponentiation,
     * which we learnt about.
     *
     * @param base     the base value
     * @param exponent the exponent value
     * @param modulus  the modulus value
     * @return the result of (base^exponent) % modulus
     */
    public static BigInteger modularExponentiation(BigInteger base, BigInteger exponent, BigInteger modulus) {
        BigInteger result = BigInteger.ONE; // Initialize result as 1
        base = base.mod(modulus); // Reduce base modulo modulus

        // Convert exponent to binary and process each bit
        while (exponent.compareTo(BigInteger.ZERO) > 0) {
            // If the least significant bit is 1, multiply the result by the current base
            if (exponent.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                result = (result.multiply(base)).mod(modulus);
            }
            // Square the base
            base = (base.multiply(base)).mod(modulus);
            // Shift the exponent right by 1
            exponent = exponent.shiftRight(1);
        }

        return result;
    }
}

/**
 * The {@code DiffieHellmanKeyExchang} class demonstrates Diffie-Hellman key
 * exchange to compute a shared secret
 * and derive an AES key from that secret using SHA-256. This was needed to
 * start the assignment. I origionally had this in a seperate file but moved it
 * to this file incase you need to grade it.
 */
class DiffieHellmanKeyExchange {

    /**
     * The main method that executes the Diffie-Hellman key exchange process.
     * It uses predefined values for p (prime), g (generator), and A (public value),
     * given for the assignment.
     * The method calculates the public key B and the shared secret, then derives an
     * AES key.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Given values for Diffie-Hellman
        String hexP = "b59dd79568817b4b9f6789822d22594f376e6a9abc0241846de426e5dd8f6eddef00b465f38f509b2b18351064704fe75f012fa346c5e2c442d7c99eac79b2bc8a202c98327b96816cb8042698ed3734643c4c05164e739cb72fba24f6156b6f47a7300ef778c378ea301e1141a6b25d48f1924268c62ee8dd3134745cdf7323";
        String hexG = "44ec9d52c8f9189e49cd7c70253c2eb3154dd4f08467a64a0267c9defe4119f2e373388cfa350a4e66e432d638ccdc58eb703e31d4c84e50398f9f91677e88641a2d2f6157e2f4ec538088dcf5940b053c622e53bab0b4e84b1465f5738f549664bd7430961d3e5a2e7bceb62418db747386a58ff267a9939833beefb7a6fd68";
        String hexA = "5af3e806e0fa466dc75de60186760516792b70fdcd72a5b6238e6f6b76ece1f1b38ba4e210f61a2b84ef1b5dc4151e799485b2171fcf318f86d42616b8fd8111d59552e4b5f228ee838d535b4b987f1eaf3e5de3ea0c403a6c38002b49eade15171cb861b367732460e3a9842b532761c16218c4fea51be8ea0248385f6bac0d";

        BigInteger p = new BigInteger(hexP, 16);
        BigInteger g = new BigInteger(hexG, 16);
        BigInteger A = new BigInteger(hexA, 16);

        // Generate private value b
        // I uncommented and hardcoded in the value I got here.
        // SecureRandom random = new SecureRandom();
        BigInteger b = new BigInteger(
                "4cb60deae5e7f7df0e68746ab687d30bad8abc6e73db555d87559417c269745c589c6c15c578f49bc92eb95e894700110e93728d81664e2e1c5dd896714a6bd18dcd7bef2d51832fe5df84fc3a2c65a7b7ef1ffc09b0a8840df17f4c7e1526c32bfda433b83c4f60954066eea80b743a41071c75ff3aa52986ff4feffeb5c876",
                16); // My b value

        // Generate my public value B = g^b (mod p)
        BigInteger B = ModularExponentiation.modularExponentiation(g, b, p);
        ;

        // Calculate the shared secret s = A^b (mod p)
        BigInteger sharedSecret = ModularExponentiation.modularExponentiation(A, b, p);

        // Derive the AES key from the shared secret
        byte[] aesKey = generateAESKey(sharedSecret);
    }

    /**
     * Generates a 256-bit AES key by hashing the shared secret using SHA-256.
     *
     * @param sharedSecret the shared secret value calculated from the Diffie-Hellman exchange
     * @return a byte array containing a 256-bit (32 bytes) AES key
     */
    public static byte[] generateAESKey(BigInteger sharedSecret) {
        try {
            // Convert the shared secret to a byte array
            byte[] secretBytes = sharedSecret.toByteArray();

            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Compute the SHA-256 hash of the shared secret
            byte[] aesKey = digest.digest(secretBytes);

            return aesKey;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating AES key", e);
        }
    }
}

/**
 * The {@code GenerateIv} class was used to generate a 128-bit Initialization Vector (IV) for AES encryption.
 * Again this was in its own file to start the assignment and then I moved it in here.
 */
class GenerateIv {
    /**
     * The main method that generates a random 128-bit IV using a SecureRandom instance 
     * and writes it to a file ("IV.txt").
     *
     * @param args command-line arguments (not used)
     * @throws Exception if an error occurs during IV generation or file writing
     */
    public static void main(String[] args) throws Exception {
        // Generate a 128-bit (16-byte) IV using SecureRandom
        byte[] iv = new byte[16]; // 128 bits = 16 bytes
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        System.out.println("IV: " + Assignment1.toHex(iv));

        // Write the IV to a file (IV.txt)
        try (FileOutputStream ivOut = new FileOutputStream("IV.txt")) {
            ivOut.write(iv);
            System.out.println("IV successfully generated and saved to IV.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}