Lintcode 180 - Binary Representation.java

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if(n == null || n.equals("") || n.length() == 0) {
            return "0";
        }
        
        String[] result = n.split("\\.");
        
        if(result.length == 2) {
            String decimal = parseDecimal(result[1]);
            String integer = parseInteger(result[0]);
            if(decimal.equals("ERROR")) {
                return "ERROR";
            } else if(decimal.equals("0") || decimal.equals("")) {
                return integer;
            } else {
                return integer + "." + decimal;
            }
        } else {
            return parseInteger(result[0]);
        }
    }
    
    
    public String parseDecimal(String decimalPart) {
        StringBuffer binary = new StringBuffer("");
        double d = Double.parseDouble("0." + decimalPart);
        while(d > 0) {
            if (binary.length() > 31) {
                return "ERROR";
            }
            
            d *= 2;
            if(d >= 1) {
                binary.append("1");
                d -= 1;
            } else {
                binary.append("0");
            }
        }

        return binary.toString();
    }
    
    public String parseInteger(String integerPart) {
        StringBuffer binary = new StringBuffer("");
        int n = Integer.parseInt(integerPart);
        if(n == 0) {
            return "0";
        }
        while(n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        
        return binary.toString();
        
    }
}