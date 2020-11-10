//71
//奇怪的方法增加了
class Solution {
    public String simplifyPath(String path) {
        if(path.length() == 0 || path == null) return path;
        
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] newPath = path.split("/");
        
        for(String p : newPath){
            if(p.equals(".") || p.isEmpty()) {
                continue;
            }else if(p.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(p);
            }
        }
        
        
        while(!stack.isEmpty()){
            res.insert(0, stack.pop());
            res.insert(0, '/');
            
        }
        
        return res.length() > 0 ? res.toString() : "/";
    }
}