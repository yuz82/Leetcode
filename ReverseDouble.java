public class ReverseDouble {

    public static double reverse1(double num) {
        String snum = String.valueOf(num);
        char[] tmp = snum.toCharArray();
        int length = tmp.length;
        for (int i = 0; i < length / 2; i++) {
            char a = tmp[i];
            tmp[i] = tmp[length - 1 - i];
            tmp[length - 1 - i] = a;
        }
        return Double.parseDouble(new String(tmp));
    }

    public static double reverse(double num) {
        BigDecimal bnum = BigDecimal.valueOf(num);
        BigDecimal one = new BigDecimal(1);
        BigDecimal zero = new BigDecimal(0);
        BigDecimal ten = new BigDecimal(10);
        int count = 0;
        while (bnum.remainder(one).compareTo(zero) != 0) {
            bnum = bnum.multiply(ten);
            count++;
        }
        BigDecimal result = new BigDecimal(0);
        while (bnum.compareTo(zero) !=0) {
            result = result.multiply(ten).add(bnum.remainder(ten));
            bnum = bnum.add(bnum.remainder(ten).negate()).divide(ten);
            count--;
        }
        while (count < 0) {
            result = result.divide(ten);
            count++;
        }
        return result.doubleValue();
    }

    public static void main(String[] args) {
        double a = 123.45213;
        System.out.println(reverse(a));
    }
}
Status API Training Shop Blog About Pricing
© 2015 GitHub, Inc. Terms Privacy Security Contact Help
