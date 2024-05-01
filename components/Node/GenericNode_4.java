public class GenericNode_4<D> extends GenericNode_3<D>{
    
    private GenericNode_4<D> down;
    
    public GenericNode_4(D data) {
        super(data);
        this.down = null;
    }
    
    public GenericNode_4(D data, GenericNode_4<D> tail) {
        super(data, tail);
        this.down = null;
    }
    
    public GenericNode_4(D data, GenericNode_4<D> tail, GenericNode_4<D> next) {
        super(data, tail, next);
        this.down = null;
    }
    public GenericNode_4(D data, GenericNode_4<D> tail, GenericNode_4<D> next, GenericNode_4<D> up) {
        super(data, tail, next, up);
        this.down = null;
    }
    public GenericNode_4(D data, GenericNode_4<D> tail, GenericNode_4<D> next, GenericNode_4<D> up, GenericNode_4<D> down) {
        super(data, tail, next, up);
        this.down = down;
    }
    
    public GenericNode_4<D> next() {
        return (GenericNode_4<D>) super.next();
    }
    public void next(GenericNode_4<D> next) {
        super.next(next);
    }
    public GenericNode_4<D> previous() {
        return (GenericNode_4<D>) super.previous();
    }
    public void previous(GenericNode_4<D> previous) {
        super.previous(previous);
    }
    public D data() {
        return super.data();
    }
    public void data(D data) {
        super.data(data);
    }
    public GenericNode_4<D> up() {
        return (GenericNode_4<D>) super.up();
    }
    public void up(GenericNode_4<D> up) {
        super.up(up);
    }
    public GenericNode_4<D> down() {
        return down;
    }
    public void down(GenericNode_4<D> down) {
        this.down = down;
    }
}
