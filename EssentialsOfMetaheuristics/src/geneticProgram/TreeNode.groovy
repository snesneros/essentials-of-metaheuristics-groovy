package geneticProgram

class TreeNode {
    def children = [];

    def arity = 0
    def value;

    def evaluate(variableValueMap){
        assert(children.size() == arity)
        if(arity == 0){
            if(value.class == Integer){
                value
            }
            else{
                variableValueMap.getAt(value)
            }
        }
        else{
            value(children)
        }
    }

}
