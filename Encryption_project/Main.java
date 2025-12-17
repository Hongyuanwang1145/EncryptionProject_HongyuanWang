class Main {


// Layer 2: ASCII +1 cipher
String enc2 = shiftForward(enc1);
Input.writeFile("Encode2.txt", enc2);


// Layer 3: Reverse string
String enc3 = reverse(enc2);
Input.writeFile("Encode3.txt", enc3);


// Encoding the plaintext:
    String file = Input.readFile("Original.txt");
    // Encode level 1 (substitution)
    String encodedMsg1 = subEncryption(file,sub,sub2);
    Input.writeFile("Encode1.txt", encodedMsg1);
    // // Encode level 2 (cipher with no wrap)
    String encodedMsg2 = encode(encodedMsg1);
    Input.writeFile("Encode2.txt", encodedMsg2);
    // // Encode level 3 (string manipulation - reverse)
    String encodedMsg3 = reverse(encodedMsg2);
    Input.writeFile("Encode3.txt", encodedMsg3);


   
    // Decoding the ciphertext:
    String file2 = Input.readFile("Encode3.txt");
    // Decode level 1  (string manipulation - reverse)
    String decodedMsg1 = reverse(file2);
    Input.writeFile("Decode1.txt", decodedMsg1);
    // Decode level 2 (cipher with no wrap)
    String decodedMsg2 = decode(decodedMsg1);
    Input.writeFile("Decode2.txt", decodedMsg2);
    // Decode level 3 (substitution)
    String decodedMsg3 = subEncryption(decodedMsg2, sub2, sub);
    Input.writeFile("Decode3.txt", decodedMsg3);
String encryptedText = Input.readFile("Encode3.txt");


// Reverse string back
String dec1 = reverse(encryptedText);
Input.writeFile("decode1.txt", dec1);


// ASCII -1 cipher
String dec2 = shiftBackward(dec1);
Input.writeFile("decode2.txt", dec2);


// Reverse Webdings substitution
String dec3 = substitute(dec2, symbols, letters);
Input.writeFile("decode3.txt", dec3);
}


// Reverses a string
String reverse(String text) {
    String result = "";
    for (int i = 0; i < text.length(); i++) {
    result = text.charAt(i) + result;
}
return result;
}



String shiftForward(String text) {
String result = "";
    for (int i = 0; i < text.length(); i++) {
    result += (char)(text.charAt(i) + 1);
}
return result;
}



String shiftBackward(String text) {
String result = "";
    for (int i = 0; i < text.length(); i++) {
    result += (char)(text.charAt(i) - 1);
}
return result;
}


String substitute(String text, char[] from, char[] to) {
String result = "";
    for (int i = 0; i < text.length(); i++) {
    char current = text.charAt(i);
    int index = indexOf(current, from);
    if (index != -1) {
    result += to[index];
}  else {
    result += current;
}
}
return result;
}


int indexOf(char c, char[] array) {
    for (int i = 0; i < array.length; i++) {
    if (array[i] == c) {
return i;
}
}
return -1;
}
