public class GenericNode_1<D> {
    
    private GenericNode_1<D> next;
    private D data;

    public GenericNode_1(D data) {
        this.data = data;
        this.next = null;
    }

    public GenericNode_1(D data, GenericNode_1<D> next) {
        this.data = data;
        this.next = next;
    }

    public D data() {
        return data;
    }
    public void data(D data) {
        this.data = data;
    }
    public GenericNode_1<D> next() {
        return next;
    }
    public void next(GenericNode_1<D> next) {
        this.next = next;
    }
}
