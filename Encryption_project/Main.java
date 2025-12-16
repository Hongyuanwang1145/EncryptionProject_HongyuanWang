class Main {


// Layer 2: ASCII +1 cipher
String enc2 = shiftForward(enc1);
Input.writeFile("Encode2.txt", enc2);


// Layer 3: Reverse string
String enc3 = reverse(enc2);
Input.writeFile("Encode3.txt", enc3);


// -------- DECRYPTION --------
String encryptedText = Input.readFile("Encode3.txt");


// Reverse string back
String dec1 = reverse(encryptedText);
Input.writeFile("Decode1.txt", dec1);


// ASCII -1 cipher
String dec2 = shiftBackward(dec1);
Input.writeFile("Decode2.txt", dec2);


// Reverse Webdings substitution
String dec3 = substitute(dec2, symbols, letters);
Input.writeFile("Decode3.txt", dec3);
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
