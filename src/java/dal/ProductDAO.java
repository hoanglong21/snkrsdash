package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Category;
import model.Image;
import model.Product;

public class ProductDAO extends DBContext {

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "select p.*, c.Name as Category, a.Username as Account from Products p \n"
                + " inner join Categories c on p.CatID = c.ID \n"
                + " inner join Accounts a on p.OwnerID = a.ID";

        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setCatID(rs.getInt("CatID"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setDescription(rs.getString("Description"));
                p.setAcc(new Account(rs.getInt("OwnerID"), rs.getString("Account")));
                p.setCate(new Category(rs.getInt("CatID"), rs.getString("Category")));
                p.setImgs(imgs);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getNew() {
        List<Product> list = new ArrayList<>();
        String sql = "select top 8 p.*, c.Name as Category, a.Username as Account from Products p \n"
                + " inner join Categories c on p.CatID = c.ID \n"
                + " inner join Accounts a on p.OwnerID = a.ID order by id desc";

        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setCatID(rs.getInt("CatID"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setDescription(rs.getString("Description"));
                p.setAcc(new Account(rs.getInt("OwnerID"), rs.getString("Account")));
                p.setCate(new Category(rs.getInt("CatID"), rs.getString("Category")));
                p.setImgs(imgs);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getByCategoryID(int catID) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.*, c.Name as Category, a.Username as Account from Products p \n"
                + " inner join Categories c on p.CatID = c.ID \n"
                + " inner join Accounts a on p.OwnerID = a.ID where CatID = " + catID;

        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setCatID(rs.getInt("CatID"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setDescription(rs.getString("Description"));
                p.setAcc(new Account(rs.getInt("OwnerID"), rs.getString("Account")));
                p.setCate(new Category(rs.getInt("CatID"), rs.getString("Category")));
                p.setImgs(imgs);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getListByPage(List<Product> list,
            int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Product> search(String key) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.*, c.Name as Category, a.Username as Account from Products p \n"
                + " inner join Categories c on p.CatID = c.ID \n"
                + " inner join Accounts a on p.OwnerID = a.ID \n"
                + " where p.name like ? or p.description like ? or a.Username like ?";

        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";
        try {
            String alo = "%" + key + "%";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, alo);
            st.setString(2, alo);
            st.setString(3, alo);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setCatID(rs.getInt("CatID"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setDescription(rs.getString("Description"));
                p.setAcc(new Account(rs.getInt("OwnerID"), rs.getString("Account")));
                p.setCate(new Category(rs.getInt("CatID"), rs.getString("Category")));
                p.setImgs(imgs);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getByPrice(int[] below, int[] upto) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.*, c.Name as Category, a.Username as Account from Products p \n"
                + " inner join Categories c on p.CatID = c.ID \n"
                + " inner join Accounts a on p.OwnerID = a.ID \n"
                + " where 1=1 and ";
        int size = below.length;
        for (int i = 0; i < size; i++) {
            if (upto[i] != -1) {
                sql += " ( p.price < " + upto[i];
            }
            sql += " and p.price > " + below[i] + " ) ";
            if (i != size - 1) {
                sql += " or ";
            }
        }

        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setCatID(rs.getInt("CatID"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setDescription(rs.getString("Description"));
                p.setAcc(new Account(rs.getInt("OwnerID"), rs.getString("Account")));
                p.setCate(new Category(rs.getInt("CatID"), rs.getString("Category")));
                p.setImgs(imgs);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getByID(int id) {
//        List<Product> list = new ArrayList<>();
        String sql = "select p.*, c.Name as Category, a.Username as Account from Products p \n"
                + " inner join Categories c on p.CatID = c.ID \n"
                + " inner join Accounts a on p.OwnerID = a.ID where p.id=?";

        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setCatID(rs.getInt("CatID"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setDescription(rs.getString("Description"));
                p.setAcc(new Account(rs.getInt("OwnerID"), rs.getString("Account")));
                p.setCate(new Category(rs.getInt("CatID"), rs.getString("Category")));
                p.setImgs(imgs);

                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getByAccountID(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.*, c.Name as Category, a.Username as Account from Products p \n"
                + " inner join Categories c on p.CatID = c.ID \n"
                + " inner join Accounts a on p.OwnerID = a.ID where a.ID = ? ";

        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setCatID(rs.getInt("CatID"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setDescription(rs.getString("Description"));
                p.setAcc(new Account(rs.getInt("OwnerID"), rs.getString("Account")));
                p.setCate(new Category(rs.getInt("CatID"), rs.getString("Category")));
                p.setImgs(imgs);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void add(Product p, Account a) {
        String sql = "insert into Products (Name, Price, Quantity, CatID, OwnerID, Description)"
                + "values (?,?,?,?,?,?)";
        String sql2 = "insert into Images (Address, ProductID)"
                + " values (?,?)";

        String sql3 = "SELECT TOP (1) [ID]\n"
                + "  FROM [snkrsdash].[dbo].[Products] order by id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setInt(3, p.getQuantity());
            st.setInt(4, p.getCatID());
            st.setInt(5, a.getID());
            st.setString(6, p.getDescription());
            st.executeUpdate();
            PreparedStatement st3 = connection.prepareStatement(sql3);
            ResultSet rs3 = st3.executeQuery();
            int id = -1;
            if (rs3.next()) {
                id = rs3.getInt("ID");
            }
            if (id == -1) {
                return;
            }
            for (Image img : p.getImgs()) {
                PreparedStatement st2 = connection.prepareStatement(sql2);
                st2.setString(1, img.getAddress());
                st2.setInt(2, id);
                st2.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int id, Account a) {
        //check authentication
        String sql0 = "select * from Products \n"
                + "where id = ? and OwnerID = ?";
        try {
            PreparedStatement st0 = connection.prepareStatement(sql0);
            st0.setInt(1, id);
            st0.setInt(2, a.getID());
            ResultSet rs = st0.executeQuery();
            if (rs.next()) {
                // ok
            } else {
                //fake
                if (a.getUsername().equals("admin")) {
                    //ok
                } else {
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            return;
        }
        //end of check
        String sql = "delete Images where ProductID = ?";
        String sql2 = "delete Products where id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            PreparedStatement st2 = connection.prepareStatement(sql2);
            st2.setInt(1, id);
            st2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deletePic(String name) {
        String sql = "delete from Images where address = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void upPro(Product p, List<Image> list) {
        String sql = "  update Products \n"
                + "  set Name = ?, price = ?, Quantity = ?, CatID = ?, Description = ?\n"
                + "  where id = ?";
        String sql2 = "  insert into Images (address, Productid) \n"
                + "  values (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setInt(3, p.getQuantity());
            st.setInt(4, p.getCatID());
            st.setString(5, p.getDescription());
            st.setInt(6, p.getID());
            st.executeUpdate();
            for (int i = 0; i < list.size(); i++) {
                PreparedStatement st2 = connection.prepareStatement(sql2);
                st2.setString(1, list.get(i).getAddress());
                System.out.println(list.get(i).getAddress());
                st2.setInt(2, p.getID());
                st2.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Product> relates(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "select TOP 8 p.*, c.Name as Category, a.Username as Account from Products p \n"
                + " inner join Categories c on p.CatID = c.ID \n"
                + " inner join Accounts a on p.OwnerID = a.ID where CatID = ?\n"
                + "ORDER BY NEWID()";

        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setCatID(rs.getInt("CatID"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setDescription(rs.getString("Description"));
                p.setAcc(new Account(rs.getInt("OwnerID"), rs.getString("Account")));
                p.setCate(new Category(rs.getInt("CatID"), rs.getString("Category")));
                p.setImgs(imgs);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getByOwner(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.*, c.Name as Category, a.Username as Account from Products p \n"
                + " inner join Categories c on p.CatID = c.ID \n"
                + " inner join Accounts a on p.OwnerID = a.ID where ownerId = ?";

        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setCatID(rs.getInt("CatID"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setDescription(rs.getString("Description"));
                p.setAcc(new Account(rs.getInt("OwnerID"), rs.getString("Account")));
                p.setCate(new Category(rs.getInt("CatID"), rs.getString("Category")));
                p.setImgs(imgs);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> filter(int Available, int[] categories, int Stars, double from, double to, String name, String sort) {
        List<Product> list = new ArrayList<>();
        String sql = "with t as(\n" +
"			select p.*, c.Name as Category, a.Username as Account, fb.Stars, OD.ODQuantity, p.Price*1.176470588235294 as FakePrice from Products p \n" +
"                inner join Categories c on p.CatID = c.ID\n" +
"             inner join Accounts a on p.OwnerID = a.ID\n" +
"               left join (  select ProductID, avg(stars) as Stars from Feedbacks \n" +
"             group by ProductID) fb on p.ID = fb.ProductID \n" +
"          left join ( select ProductID as ODproID, sum(Quantity) as ODQuantity from OrderDetails  \n" +
"          group by ProductID) OD on p.ID = OD.ODproID\n" +
"		  )\n" +
"		  select * from t  where 1=1";

        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";

        //p.name like ? or p.description like ? or a.Username like ? \\ String alo = "%" + key + "%";
        if (Available == 0) {
            sql += " and quantity < 1";
        } else  if (Available == 1){
            sql += " and quantity >= 1";
        }
        if (categories != null) {
            for (int i = 0; i < categories.length; i++) {
                if (i == 0) {
                    sql += " and ( CatID = " + categories[i];
                } else {
                    sql += " or CatID = " + categories[i];
                }
                if (i == categories.length - 1) {
                    sql += " ) ";
                }
            }
        }
        if (Stars > 0) {
            sql += " and Stars >= " + Stars;
        }
        if (from > 0) {
            sql += " and fakePrice >= " + from;
        }
        if (to > 0) {
            sql += " and fakePrice <= " + to;
        }
        if (name != null && !name.equals("")) {
            sql += " and ( t.name like '%" + name + "%' or t.description like '%" + name + "%' or t.Account like  '%" + name + "%' )";
        }
        if (sort != null && !sort.equals("")) {
            sql += sort;
        }

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setCatID(rs.getInt("CatID"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setDescription(rs.getString("Description"));
                p.setAcc(new Account(rs.getInt("OwnerID"), rs.getString("Account")));
                p.setCate(new Category(rs.getInt("CatID"), rs.getString("Category")));
                p.setImgs(imgs);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public static void main(String[] args) {
        ProductDAO c = new ProductDAO();
        List<Product> list = c.getAll();
        System.out.println(list.get(0).getName());

        for (Image s : list.get(0).getImgs()) {
            System.out.println(s.getAddress());
        }
    }
}
