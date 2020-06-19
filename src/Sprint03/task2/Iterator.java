package Sprint03.task2;

class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    // Write your code here


    public class Iterator {
        private int counter = 0;

        private Iterator(){

        }

        public boolean hasNext(){

            if(counter<names.length && names[counter]!= null){
                return true;
            } else
                return false;
        }

        public String next(){

            return names[counter++];

        }
    }
}
