public class SortableRecord extends Record implements Comparable<SortableRecord>{
    SortableRecord(String id, int m, int j, int e){
        super(id, m, j, e);
    }

    @Override
    public int compareTo(SortableRecord other) {
        if (other.score_total != this.score_total) {
            return other.score_total > this.score_total ? 1 : -1;
        } else if (other.score_math != this.score_math) {
            return other.score_math > this.score_math ? 1 : -1;
        } else if (other.score_Japanese != this.score_Japanese) {
            return other.score_Japanese > this.score_Japanese ? 1 : -1;
        } else if (other.score_English != this.score_English) {
            return other.score_English > this.score_English ? 1 : -1;
        } else {
            return 0;
        }
    }
}
