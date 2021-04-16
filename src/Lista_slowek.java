
public class Lista_slowek implements Comparable<Lista_slowek> {
        private  String s_polski;
        private  String s_niemiecki;
        private  int wiem;
        private  int nie_wiem;

        public Lista_slowek(String s_polski, String s_niemiecki, int wiem, int nie_wiem) {
            this.s_polski = s_polski;
            this.s_niemiecki = s_niemiecki;
            this.wiem = wiem;
            this.nie_wiem = nie_wiem;
        }

        public String getS_polski() {
            return s_polski;
        }

        public String getS_niemiecki() {
            return s_niemiecki;
        }

        public int getWiem() {
            return wiem;
        }

        public int getNie_wiem() {
            return nie_wiem;
        }

        public void setWiem(int wiem) {
            this.wiem = wiem;
        }

        public void setNie_wiem(int nie_wiem) {
            this.nie_wiem = nie_wiem;
        }

        @Override
        public int compareTo(Lista_slowek o) {
            if (this.getWiem()<o.getWiem()) return -1;
            if (this.getWiem()>o.getWiem()) return 1;
            return 0;
        }
    }

