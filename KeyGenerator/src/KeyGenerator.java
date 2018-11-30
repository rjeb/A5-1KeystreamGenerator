
public class KeyGenerator {
	String keystream;
	String register1;
	String register2;
	String register3; 
	
	private KeyGenerator() {
		this.keystream = "";
	}
	
	public KeyGenerator(String key) {
		//sets 3 registers based on key
		this.register1 = key.substring(0, 19);
		this.register2 = key.substring(19, 41);
		this.register3 = key.substring(41);
		this.keystream = "";
		
		//tests registers are divided correctly
		//System.out.println(register1 + "\n" + register2 + "\n" + register3);
	}
	
	public void generateKeystream(int length) {
		this.keystream = "";
		char majorityBit = '0', temp;
		char register1xor = '0', register2xor = '0', register3xor = '0';
		
		for(int i = 0; i < length; i++) {
			register1xor = xorBit(xorBit(xorBit(register1.charAt(13), register1.charAt(16)), register1.charAt(17)), register1.charAt(18));
			register2xor = xorBit(register2.charAt(20), register2.charAt(21));
			register3xor = xorBit(xorBit(xorBit(register3.charAt(7), register3.charAt(20)), register3.charAt(21)),register3.charAt(22));
			majorityBit = register1xor;
			if (register2xor == majorityBit) {
				//majorityBit is already set to majority bit
			}
			else {
				//if reg1 & reg2 differ, majority depends on register 3
				majorityBit = register3xor;
			}
			//shifts registers if they are part of the majority
			if (register1xor == majorityBit) {
				register1 = register1xor + register1.substring(0, register1.length()-1);
			}
			if (register2xor == majorityBit) {
				register2 = register2xor + register2.substring(0, register2.length()-1);
			}
			if (register3xor == majorityBit) {
				register3 = register3xor + register3.substring(0, register3.length()-1);
			}
			temp = xorBit(xorBit(register1.charAt(18), register2.charAt(21)), register3.charAt(22));
			keystream += temp;
		}
	}

	public String getKeystream() {
		return keystream;
	}

	public void setKeystream(String keystream) {
		this.keystream = keystream;
	}
	
	private char xorBit(char a, char b) {
		if (a == '1' && b == '1') {
			return '0';
		}
		else if (a == '0' && b == '0') {
			return '0';
		}
		return '1';
	}
	
	
}
