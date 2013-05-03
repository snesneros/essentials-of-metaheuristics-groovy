package geneticProgram

class TreeNode {
    def children = [];

    def arity = 0
    def value
    def valueString = value

    def evaluate(){
        assert(children.size() == arity)
        if(arity == 0){
            value
        }
        else{
            def valueArray = []
            children.each{child ->
                valueArray.add(child.evaluate())
            }
            value(valueArray)
        }
    }
    
    def getTreeSize(){
        def sum = 1
        children.each{child ->
            sum += child.getTreeSize()
        }
        return sum
    }
    
    def getTreeDepth(){
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
