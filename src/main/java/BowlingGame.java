public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
    	if (bowlingCode == null) return 0;
    	    	String[] frame = bowlingCode.split("\\|");
    	
    	int f0 = 0, f1 = 0, current = 0, i = 0, sum = 0;
    	char first, second;
    	while (i < 10) {
    		first = frame[i].charAt(0);
    		switch (first) {
    		case 'X':
    			current = 10;
    			
    			if (f1 > 0) {
    				sum += current;
    				f1--;
    			}
    			if (f0 > 0) {
    				sum += current;
    				f0 = 0;
    			}
    			break;
    		case '-':
				second = frame[i].charAt(1);
    			if (second == '/') {
    				current = 10;
    			} else if (second <= '9' && second >= '0') {
    				current = second - '0';
    			} else if (second == '-') {
    				current = 0;
    			} else {
    				return 0;
    			}
    			
    			if (f1 == 1) {
    				f1 = 0;
    			} else if (f1 == 2) {
    				sum += current;
    				f1 = 0;
    			}
    			if (f0 > 0) {
    				f0 = 0;
    			}
    			break;
    		default:
    			if (first > '9' || first < '0') {
    				return 0;
    			}
    			second = frame[i].charAt(1);
    			if (second == '/') {
    				current = 10;
    			} else if (second <= '9' && second >= '0') {
    				current = first - '0' + second - '0';
    			} else if (second == '-') {
    				current = first - '0';
    			} else {
    				return 0;
    			}
    			
    			if (f1 == 1) {
    				sum += (first - '0');
    				f1 = 0;
    			} else if (f1 == 2) {
    				sum += current;
    				f1 = 0;
    			}
    			if (f0 > 0) {
    				sum += first - '0';
    				f0 = 0;
    			}
    			break;
    		}
    		
    		sum += current;
    		
    		f0 = f1;
    		if (first == 'X') {
    			f1 = 2;
    		} else if (current == 10) {
    			f1 = 1;
    		} else {
    			f1 = 0;
    		}
    		i++;
    		//System.out.println(sum + "");
    	}
    	
    	if (frame.length == 12) {
    		if (frame[11].length() > 0) {
        		first = frame[11].charAt(0);
        		if (first == 'X') {
        			current = 10;
        		} else if (first >= '0' && first <= '9') {
        			current = first - '0';
        		} else {
        			return 0;
        		}
        	}
        	if (f1 > 0) {
    			sum += current;
    			f1 = 1;
    		}
    		if (f0 > 0) {
    			sum += current;
    		}
        	if (frame[11].length() == 2) {
        		second = frame[11].charAt(1);
        		if (second == 'X') {
        			sum += 10;
        		} else if (second >= '0' && second <= '9') {
        			sum += second - '0';
        		} else {
        			return 0;
        		}
        	}
    	}
        return sum;
    }
}