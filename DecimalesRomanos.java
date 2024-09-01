public class DecimalesRomanos {

    private static final String[] UNIDADES = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] DECENAS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] CENTENAS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] MILLARES = {"", "M", "MM", "MMM"};

    public String decimalARomano(int numero) {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 3999");
        }

        int millares = numero / 1000;
        int centenas = (numero % 1000) / 100;
        int decenas = (numero % 100) / 10;
        int unidades = numero % 10;

        return MILLARES[millares] + CENTENAS[centenas] + DECENAS[decenas] + UNIDADES[unidades];
    }
}