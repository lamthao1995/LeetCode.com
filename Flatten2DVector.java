public class Vector2D implements Iterator<Integer> {
    int indexL = 0;
    int indexE = 0;
    int totalList = 0;
    List<List<Integer>> vec;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec = vec2d;
        this.totalList = vec2d.size();
         while(indexL < totalList){
                if(vec.get(indexL).size() != 0){
                    break;
                }
                indexL++;
            }
    }

    @Override
    public Integer next() {
        Integer val = null;
        val = indexE < vec.get(indexL).size() ? vec.get(indexL).get(indexE++) : null;
        if(indexE >= vec.get(indexL).size()){
            indexL++;
            indexE = 0;
            while(indexL < totalList){
                if(vec.get(indexL).size() != 0){
                    break;
                }
                indexL++;
            }
        }
        return val;
    }

    @Override
    public boolean hasNext() {
        if(totalList == 0 || indexL == totalList){
            return false;
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */