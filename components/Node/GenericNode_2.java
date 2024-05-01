public class GenericNode_2<D> extends GenericNode_1<D> {

    private GenericNode_2<D> previous;
    
    public GenericNode_2(D data) {
        super(data);
        this.previous = null;
    }
    
    public GenericNode_2(D data, GenericNode_2<D> tail) {
        super(data);
        this.previous = tail;
    }
    
    public GenericNode_2(D data, GenericNode_2<D> tail, GenericNode_2<D> next) {
        super(data, next);
        this.previous = tail;
    }

    public GenericNode_2<D> next() {
        return (GenericNode_2<D>) super.next();
    }
    public void next(GenericNode_2<D> next) {
        super.next(next);
    }
    public GenericNode_2<D> previous() {
        return previous;
    }
    public void previous(GenericNode_2<D> previous) {
        this.previous = previous;
    }
    public D data() {
        return super.data();
    }
    public void data(D data) {
        super.data(data);
    }
}
