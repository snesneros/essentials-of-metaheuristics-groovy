package geneticProgram

class TreeNode {
    def children = [];

    def arity = 0
    def value
    def valueString = value

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
            def valueArray = []
            children.each{child ->
                valueArray.add(child.evaluate(variableValueMap))
            }
            value(valueArray)
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
    
    def String toString(){
        def str = ""
        children.each{child ->
            str += child.toString()
        }
        if(valueString == null){
            valueString = value
        }
        str += " " + valueString
        return str
    }
    
    def clone() {
        new TreeNode(children : this.children, arity : this.arity, value : this.value, valueString : this.valueString)
    }

}
