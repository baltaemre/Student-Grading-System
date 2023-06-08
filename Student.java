public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double average;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }

    public void addBulkExamNote(int mat,int matOralExam,int fizik,int fizikOralExam,int kimya,int kimyaOralExam){

        if (mat >= 0 && mat <= 100) {
            this.mat.totalNote = (mat*0.8)+(matOralExam*0.2);
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.totalNote = (fizik*0.8)+(fizikOralExam*0.2);
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.totalNote = (kimya*0.8)+(kimyaOralExam*0.2);
        }

    }

    public void isPass() {
        if (this.mat.totalNote == 0 || this.fizik.totalNote == 0 || this.kimya.totalNote == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.average);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.average = (this.fizik.totalNote + this.kimya.totalNote + this.mat.totalNote) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.average > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.totalNote);
        System.out.println("Fizik Notu : " + this.fizik.totalNote);
        System.out.println("Kimya Notu : " + this.kimya.totalNote);
    }

}