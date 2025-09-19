class Spreadsheet {
    int[][] ss;
    public Spreadsheet(int rows) {
        ss = new int[rows+1][26];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1,cell.length()));
        System.out.println(col+"__"+row);
        ss[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1,cell.length()));
        ss[row][col] = 0;
    }
    public static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }
    public int getValue(String formula) {
        String[] vals = formula.substring(1,formula.length()).split("\\+");
        int res = 0;
        if(isNumeric(vals[0])&&isNumeric(vals[1])){
            return Integer.parseInt(vals[0])+Integer.parseInt(vals[1]);
        }else if(!isNumeric(vals[0])&&isNumeric(vals[1])){
            int row = Integer.parseInt(vals[0].substring(1,vals[0].length()));
            return ss[row][vals[0].charAt(0)-'A'] + Integer.parseInt(vals[1]);
        }else if(isNumeric(vals[0])&&!isNumeric(vals[1])){
            int row = Integer.parseInt(vals[1].substring(1,vals[1].length()));
            return ss[row][vals[1].charAt(0)-'A'] + Integer.parseInt(vals[0]);
        }
        int row1 = Integer.parseInt(vals[1].substring(1,vals[1].length()));
        int row2 = Integer.parseInt(vals[0].substring(1,vals[0].length()));
        return ss[row1][vals[1].charAt(0)-'A'] + ss[row2][vals[0].charAt(0)-'A'];
        
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */