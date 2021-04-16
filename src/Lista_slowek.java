// List of seters ang getters for ArrayList of objects(Lista_slowek).
public class Lista_slowek implements Comparable<Lista_slowek> {
        private  String s_pl;
        private  String s_de;
        private  int know;
        private  int d_know;

        public Lista_slowek(String s_pl, String s_de, int know, int d_know) {
            this.s_pl = s_pl;
            this.s_de = s_de;
            this.know = know;
            this.d_know = d_know;
        }

        public String getS_pl() {
            return s_pl;
        }

        public String getS_de() {
            return s_de;
        }

        public int getKnow() {
            return know;
        }

        public int getD_know() { return d_know; }

        public void setS_polski(String s_pl) {
            this.s_pl = s_pl;
        }

        public void setS_niemiecki(String s_de) {
            this.s_de = s_de;
        }

        public void setKnow(int know) {
            this.know = know;
        }

        public void setD_know(int d_know) {
            this.d_know = d_know;
        }

        @Override
        public int compareTo(Lista_slowek o) {
            if (this.getKnow()<o.getKnow()) return -1;
            if (this.getKnow()>o.getKnow()) return 1;
            return 0;
        }
    }

