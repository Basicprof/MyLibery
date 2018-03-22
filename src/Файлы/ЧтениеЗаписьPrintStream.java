import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ЧтениеЗаписьPrintStream {


        public static void main(String[] args) {
            //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
            try {
                File your_file_name = new File("n");//.createTempFile("nn", null);
                OutputStream outputStream = new FileOutputStream(your_file_name);
                InputStream inputStream = new FileInputStream(your_file_name);

                Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
                ivanov.save(outputStream);
                outputStream.flush();

                Human somePerson = new Human();
                somePerson.load(inputStream);
                inputStream.close();
                //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("Oops, something wrong with my file");
            } catch (Exception e) {
                e.printStackTrace();
                // System.out.println("Oops, something wrong with save/load method");
            }
        }

        public static class Human {
            public String name;
            public List<Asset> assets = new ArrayList<>();

            public Human() {
            }

            public Human(String name, Asset... assets) {
                this.name = name;
                if (assets != null) {
                    this.assets.addAll(Arrays.asList(assets));
                }
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Human human = (Human) o;

                if (name != null ? !name.equals(human.name) : human.name != null) return false;
                return assets != null ? assets.equals(human.assets) : human.assets == null;
            }

            @Override
            public int hashCode() {
                int result = name != null ? name.hashCode() : 0;
                result = 31 * result + (assets != null ? assets.hashCode() : 0);
                return result;
            }

            public void save(OutputStream outputStream) throws Exception {
                PrintWriter writer  = new PrintWriter(outputStream);
                writer.println(this.name);
                for (Asset a: assets){
                    writer.println(a.getName());
                    writer.println(a.getPrice());
                }
                writer.flush();
            }
            public void load(InputStream inputStream) throws Exception {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                this.name = bufferedReader.readLine();
                ArrayList <String> arrayList = new ArrayList<>();
                while (bufferedReader.ready()) arrayList.add(bufferedReader.readLine());
                for (int i = 0; i < arrayList.size()-1; i+=2) {

                    this.assets.add(new Asset(arrayList.get(i),
                            Double.parseDouble(arrayList.get(i+1))));
                }
            }
        }
    }


