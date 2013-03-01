package geneticProgram

class TreeNode {
    def children = [];    
    
    def arity;
    def function;
    
    def evaluate(){
        assert(children.size() == arity)
        if(arity == 0){
            function
        }
        else{
            function(children)
        }
    }
    
}
