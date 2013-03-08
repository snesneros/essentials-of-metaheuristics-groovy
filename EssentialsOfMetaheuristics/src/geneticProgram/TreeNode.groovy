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
    
    def getTreeSize(){ //this is really terrible and we should figure out a better way to do it.
        def sum = 1
        children.each{child ->
            sum += child.getTreeSize()
        }
        return sum
    }
    def getTreeDepth(){ //this is really terrible and we should figure out a better way to do it.
        def max = 0
        children.each{child ->
            max = Math.max(child.getTreeDepth(), max)}
        return max + 1
    }

}
