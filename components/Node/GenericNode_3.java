public class GenericNode_3<D> extends GenericNode_2<D>{
        
        private GenericNode_3<D> up;
        
        public GenericNode_3(D data) {
            super(data);
            this.up = null;
        }
        
        public GenericNode_3(D data, GenericNode_3<D> tail) {
            super(data, tail);
            this.up = null;
        }
        
        public GenericNode_3(D data, GenericNode_3<D> tail, GenericNode_3<D> next) {
            super(data, tail, next);
            this.up = null;
        }
        public GenericNode_3(D data, GenericNode_3<D> tail, GenericNode_3<D> next, GenericNode_3<D> up) {
            super(data, tail, next);
            this.up = up;
        }
    
        public GenericNode_3<D> next() {
            return (GenericNode_3<D>) super.next();
        }
        public void next(GenericNode_3<D> next) {
            super.next(next);
        }
        public GenericNode_3<D> previous() {
            return (GenericNode_3<D>) super.previous();
        }
        public void previous(GenericNode_3<D> previous) {
            super.previous(previous);
        }
        public D data() {
            return super.data();
        }
        public void data(D data) {
            super.data(data);
        }
        public GenericNode_3<D> up() {
            return up;
        }
        public void up(GenericNode_3<D> up) {
            this.up = up;
        }
}