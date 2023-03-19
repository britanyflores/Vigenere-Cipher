// Author: Britany Flores
// In this programming we will encrypt and decrypt a plaintext with a key, the encryption we will be using will be the Vigenere Cipher
// The only package needed to import will be the scanner to take user input

import java.util.Scanner;


public class Vignere {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		//create scanner scan to take user input
		Scanner scan = new Scanner(System.in); 
		
		//promt user for input
		System.out.println("Please enter a key and a plaintext, be aware that the key must be the same length as the plaintext: ");
		
		String key = scan.nextLine();
		String plaintext = scan.nextLine();

		//place all white spaces from inputs
		key = key.replaceAll("\\s", "");
		plaintext = plaintext.replaceAll("\\s", "");
		
		//create alphabet array
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};		

		//print result
		System.out.println("Encryption: "+ encryption(plaintext, key, alphabet));
		
		String ciphertext = encryption(plaintext, key, alphabet);
		
		System.out.println("Decryption: " + decryption(ciphertext, key, alphabet));		
		
	}
	
	
	/*
	 * takes the plaintext, key and alphabet
	 * returns ciphertext
	 * uses ch - 'a' regex
	 */
	public static String encryption(String plaintext, String key, String[] alphabet) {
		String ciphertext = "";
		int sum = 0;
		
		for( int i = 0; i < plaintext.length(); i++) {
			char ch = plaintext.charAt(i);
			sum = ch - 'a';
			ch = key.charAt(i);
			sum += ch - 'a';

			if(sum>25) {
				sum = sum % 26;
				ciphertext = ciphertext + alphabet[sum];
			}
			else {
				ciphertext = ciphertext + alphabet[sum];
			}
			
		}
		
		return ciphertext;
	}
	
	/*
	 * takes the ciphertext, key and alphabet
	 * returns ciphertext
	 * uses ch - 'a' regex
	 */
	public static String decryption(String ciphertext, String key, String[] alphabet) {
		String plaintext = "";
		int sub = 0;
		
		for( int i = 0; i < ciphertext.length(); i++) {
			char ch = ciphertext.charAt(i);
			sub = ch - 'a';
			ch = key.charAt(i);
			sub -= ch - 'a';
			
			
			if(sub < 0) {
				sub = sub + 26;
				plaintext = plaintext + alphabet[sub];
			}
			else {
				plaintext = plaintext + alphabet[sub]; 
			}
		}
	
		return plaintext;
	}

}
