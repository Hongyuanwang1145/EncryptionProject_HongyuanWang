class Main {

  public static void main(String[] args) {
    new Main().init();
  }

  void init() {

    // substitution arrays
    char[] letters = {'a','e','i','o','u','b','g','s','t'};
    char[] symbols = {'4','2','6','3','7','!','?','$','#'};

    // encrytion
    String original = Input.readFile("Original.txt");

    //  Substitution
    String enc1 = substitute(original, letters, symbols);
    Input.writeFile("Encode1.txt", enc1);

    // ASCII +1
    String enc2 = shiftForward(enc1);
    Input.writeFile("Encode2.txt", enc2);

    //  Reverse
    String enc3 = reverse(enc2);
    Input.writeFile("Encode3.txt", enc3);

    // Decryption
    String encrypted = Input.readFile("Enc3.txt");

    // Reverse back
    String dec1 = reverse(encrypted);
    Input.writeFile("Decode1.txt", dec1);

    // ASCII -1
    String dec2 = shiftBackward(decode1);
    Input.writeFile("Decode2.txt", dec);

    // Reverse substitution
    String dec3 = substitute(dec2, symbols, letters);
    Input.writeFile("Decode3.txt", dec3);
  }


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
      } else {
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
}