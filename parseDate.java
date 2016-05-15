public static String parseDate(String str) {
    str = str.replace("th", ""); str = str.replace("rd", ""); str = str.replace("st", ""); str = str.replace("nd", "");
    String pattern = "dd MMM yyyy";
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    SimpleDateFormat outputft =  new SimpleDateFormat ("yyyy-MM-dd");
    try {
      Date date = format.parse(str);
      return outputft.format(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return "wrong";
}

System.out.println(parseDate("5th oct 2015"));//"1st Oct 2016"
