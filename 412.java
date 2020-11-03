//412 
//避免取余操作的方法 取余数对于cpu来说运算效率很低 提升性能
class Solution{
	public List<String> fizzBuzz(int n){
		List<String> res = new ArrayList<>();
		for(int i=1, fizz=0, buzz=0; i<=n; i++){
			fizz++;
			buzz++;
			if(fizz==3 && buzz ==5){
				res.add("FizzBuzz");
				fizz = 0;
				buzz0 = 0;
			}else if(fizz==3){
				res.add("Fizz");
				fizz = 0;
			}else if(buzz==5){
				res.add("Buzz");
				buzz = 0;

			}else{
				res.add(Integer.toString(i));
			}
		}
		return res;
	}
}