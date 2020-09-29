package hibernate.lesson5_2_hql;

public class Demo {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        long ID = 3;
        //  productDao.findById(ID);
        //System.out.println( productDao.findById(ID));
        //  System.out.println( productDao.findByName("table  new"));

        System.out.println(productDao.findByContainedName("ab"));
        //  System.out.println( productDao.findByPrice(59,10));
        //  System.out.println( productDao.findByNameSortedAsc());
        //  System.out.println( productDao.findByNameSortedDecs());
        //  System.out.println( productDao.findByPriceSortedDesc(59,10));
    }
}
