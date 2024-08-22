class BinaryComplement {
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                res += '1'; // use single quotes for char
            } else {
                res += '0'; // use single quotes for char
            }
        }
        return Integer.parseInt(res, 2);
    }

    public static void main(String[] args) {
        BinaryComplement bc = new BinaryComplement();
        int num = 5; // example input
        int complement = bc.findComplement(num);
        System.out.println("The binary complement of " + num + " is " + complement);
    }
}