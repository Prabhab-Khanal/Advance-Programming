package controller.database;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import javax.servlet.http.HttpSession;

import model.CartModel;
import model.PasswordEncryptionWithAes;
import model.ProductModel;
import model.UserModel;
import utils.StringUtils;

public class DatabaseController {
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(StringUtils.DRIVER_NAME);
		String url = StringUtils.LOCALHOST_URL;
		String user = StringUtils.LOCALHOST_USERNAME;
		String pass = StringUtils.LOCALHOST_PASSWORD;
		
		return DriverManager.getConnection(url, user, pass);
	}
	
	
	public int addUser(UserModel userModel) {
		try(Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement(StringUtils.INSERT_USER);
			
			st.setString(1, userModel.getUsername());
            st.setString (2, userModel.getFirstName());
            st.setString(3, userModel.getMiddleName());
            st.setString (4, userModel.getLastName()); 
            st.setDate(5, Date.valueOf(userModel.getDob())); 
            st.setString (6, userModel.getGender());
            st.setString(7, userModel.getEmail());
            st.setString(8,userModel.getPhoneNumber());
            st.setString (9, userModel.getAddress());
            st.setString(10, PasswordEncryptionWithAes.encrypt(userModel.getUsername(), userModel.getPassword()));
            st.setString(11, "User");
            int result = st.executeUpdate();
            System.out.println("UserMOdel dbcotroller"+result);
            return result > 0 ? 1 : 0;
		}
		catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public boolean usernameExists(String username) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(StringUtils.CHECK_USERNAME_EXISTENCE);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            return rs.next();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean emailExists(String email) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(StringUtils.CHECK_EMAIL_EXISTENCE);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            System.out.println(rs.next());
            return rs.next();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean phoneNumberExists(String phoneNumber) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(StringUtils.CHECK_PHONE_NUMBER_EXISTENCE);
            st.setString(1, phoneNumber);
            ResultSet rs = st.executeQuery();
            return rs.next();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
     
    }
	
	
	public int isFound(String username, String passWord) {
		try (Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement(StringUtils.GET_LOGIN_USER_INFO);
			st.setString(1, username);
			//System.out.println("IS found bhitra cha");
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				String password= rs.getString("password");
				String decryptedpwd = PasswordEncryptionWithAes.decrypt(password, username);
				if(decryptedpwd.equals(passWord)) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else {
				return -1;
			}
			
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("IS found bhitra chaina");
			return -1;
		}
		}
		
		public boolean productExists(int productId) {
			try (Connection con = getConnection()) {
	            PreparedStatement st = con.prepareStatement(StringUtils.CHECK_PRODUCT_ID_EXISTENCE);
	            st.setInt(1, productId);
	            ResultSet rs = st.executeQuery();
	            return rs.next();
	        } catch (SQLException | ClassNotFoundException ex) {
	            ex.printStackTrace();
	            return false;
	        }
		}
	     
		public int addProduct(ProductModel productModel) {
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.INSERT_PRODUCT);
				
				st.setInt(1, productModel.getProductId());
	            st.setString (2, productModel.getProductName());
	            st.setString(3, productModel.getDescription());
	            st.setFloat (4, productModel.getPrice());		            
	            st.setInt (5, productModel.getStock());
	            st.setString(6, productModel.getImageURLfromPart());
	            
	            int result = st.executeUpdate();
	            return result > 0 ? 1 : 0;
			}
			catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
				return -1;
			}
		}	
			
		
			
			
		public List<ProductModel> getAllProduct(){
			List<ProductModel> allProductList = new ArrayList<ProductModel>();
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.GET_ALL_PRODUCTS_INFO);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					ProductModel product = new ProductModel();
					
					product.setProductId(rs.getInt(1));
					product.setProductName(rs.getString(2));
					product.setDescription(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					product.setStock(rs.getInt(5));
					product.setProductImage(rs.getString(6));
					
					allProductList.add(product);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return allProductList;
		}
		
		
		public List<UserModel> getAllUsers() {
		    List<UserModel> allUserList = new ArrayList<>();
		    try (Connection con = getConnection()) {
		        PreparedStatement st = con.prepareStatement(StringUtils.GET_ALL_USER_INFO);
		        ResultSet rs = st.executeQuery();
		        while (rs.next()) {
		            UserModel user = new UserModel();
		            
		            user.setFirstName(rs.getString("first_name"));
	                user.setMiddleName(rs.getString("middle_name"));
	                user.setLastName(rs.getString("last_name"));
	                user.setDob(rs.getDate("dob").toLocalDate());
	                user.setGender(rs.getString("gender"));
	                user.setEmail(rs.getString("email"));
	                user.setPhoneNumber(rs.getString("phone_number"));
	                user.setAddress(rs.getString("address"));
	                user.setUsername(rs.getString("user_name"));
	                user.setPassword(rs.getString("password"));
	                
	                
	                // Add the UserModel object to the list
	                allUserList.add(user);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return allUserList;
		}
		
		
		public List<ProductModel> getCartProduct(int prod_id){
			List<ProductModel> CartProductList = new ArrayList<ProductModel>();
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.GET_CART_PRODUCTS_INFO);
				st.setInt(1,prod_id);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					ProductModel product = new ProductModel();
					
					product.setProductId(rs.getInt(1));
					product.setProductName(rs.getString(2));
					product.setDescription(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					product.setStock(rs.getInt(5));
					product.setProductImage(rs.getString(6));
					
					CartProductList.add(product);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return CartProductList;
		}
		
		public List<ProductModel> homeImg() {
			List<ProductModel> homepageList = new ArrayList();
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.HOMEPAGE_IMG);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					ProductModel product = new ProductModel();
					
					product.setProductId(rs.getInt(1));
					product.setProductName(rs.getString(2));
					product.setDescription(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					product.setStock(rs.getInt(5));
					product.setProductImage(rs.getString(6));
					
					homepageList.add(product);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			return homepageList;
				
			}	
		
		
		
		
		public int addNewCart(String userName) {
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.INSERT_CART_VALUES);
				
				st.setString(1, userName);
	            int result = st.executeUpdate();
	            return result > 0 ? 1 : 0;
			}
			catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
				return -1;
			}
		}
		
		public int addCartItems(int cart_id, int productId, int quantity) {
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.INSERT_CART_ITEMS);
				
				st.setInt(1, cart_id);
	            st.setInt (2, productId);
	            st.setInt(3, quantity);
	            int result = st.executeUpdate();
	            return result > 0 ? 1 : 0;
			}
			catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
				return -1;
			}
		}
		
		public int getCartID(String user) {
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.CHECK_EMPTY_CART);
				st.setString(1, user);
				ResultSet rs = st.executeQuery();
				int cart_id = 0;
				while(rs.next()) {
					cart_id= rs.getInt(1);
					System.out.println(cart_id);
				}
				return cart_id;	
			}
			catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
				return -1;
			}
		}
		public boolean checkForSameProduct(int cart_id,int product_id) {
			try(Connection con = getConnection()){
				
				PreparedStatement st = con.prepareStatement(StringUtils.CHECK_FOR_SAME_CART);
				st.setInt(1, cart_id);
				st.setInt(2, product_id);
				ResultSet rs = st.executeQuery();
				System.out.println("Check Cart For Same Product"+rs.next());
				return rs.next();
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public List<ProductModel> getSearchedProduct(String name){
			List<ProductModel> allSearchProductList = new ArrayList<ProductModel>();
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.GET_SEARCHED_PRODUCTS_INFO);
				st.setString(1,"%"+name+"%");
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					ProductModel product = new ProductModel();
					
					product.setProductId(rs.getInt(1));
					product.setProductName(rs.getString(2));
					product.setDescription(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					product.setStock(rs.getInt(5));
					product.setProductImage(rs.getString(6));
					
					allSearchProductList.add(product);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return allSearchProductList;
		}
		
		/*public ResultSet getCartInfo(int cartId) {
	        try (Connection connection = getConnection()) {
	            
	            PreparedStatement statement = connection.prepareStatement(StringUtils.CART_LIST);
	            statement.setInt(1, cartId);
	            ResultSet rs = statement.executeQuery();
	            while(rs.next()) {
	            	String productImage = rs.getString("Product_Image");
	                String productName = rs.getString("Product_Name");
	                double price = rs.getDouble("Price");
	                int quantity = rs.getInt("Quantity");
	                
	                System.out.println("Prod Img::::: "+productImage);
	                System.out.println("Prod Name::::: "+productName);
	                System.out.println("Prod Price::::: "+price);
	                System.out.println("Prod Quanity::::: "+quantity);
	            }
	            return rs;
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    */
		public  Map<Integer, Map<String, Object>>  getCartInfo(int cartId) {
			 Map<Integer, Map<String, Object>> productMap = new LinkedHashMap<>();
			
		    try (Connection connection = getConnection()){
		         PreparedStatement statement = connection.prepareStatement(StringUtils.CART_LIST); 
		        
		        statement.setInt(1, cartId);
		        try (ResultSet rs = statement.executeQuery()) {
		            while (rs.next()) {
		                Map<String, Object> row = new HashMap<>();
		                row.put("Product_Image", rs.getString("Product_Image"));
		                row.put("Product_Name", rs.getString("Product_Name"));
		                row.put("Price", rs.getDouble("Price"));
		                row.put("Quantity", rs.getInt("Quantity"));
		                
		                int productId = rs.getInt("Product_ID");
		    			productMap.put(productId, row);
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return productMap;
		}
		
		public boolean updateProduct(ProductModel product) {
		    boolean updated = false;
		    try (Connection connection = getConnection()){
		         PreparedStatement statement = connection.prepareStatement(StringUtils.UPDATE_PRODUCT); 

		        // Set the parameters for the PreparedStatement
		        statement.setString(1, product.getProductName());
		        statement.setString(2, product.getDescription());
		        statement.setFloat(3, product.getPrice());
		        statement.setInt(4, product.getStock());
		        statement.setString(5, product.getImageURLfromPart());
		        statement.setInt(6, product.getProductId());

		        // Execute the update statement
		        int rowsAffected = statement.executeUpdate();

		        // Check if any rows were affected (updated)
		        if (rowsAffected > 0) {
		            updated = true;
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return updated;
		}
		
		public int deleteProduct(int prodID) {
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.DELETE_PRODUCT);
				st.setInt(1, prodID);
				int result = st.executeUpdate();
	            return result > 0 ? 1 : 0;
			}
			catch(Exception e) {
				e.printStackTrace();
				return -1;
			}
			
		}
		
		public int deleteCartItems(int productId,int cartID) {
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.DELETE_CART_ITEM);
				st.setInt(1, productId);
				st.setInt(2, cartID);
				int result = st.executeUpdate();
	            return result > 0 ? 1 : 0;
			}
			catch(Exception e) {
				e.printStackTrace();
				return -1;
			}
		}
		
		public int updateUser(Map<String, Object> userInfo) {
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.UPDATE_USER);
				st.setString(1, (String) userInfo.get("firstName"));
				st.setString(2, (String) userInfo.get("middleName"));
				st.setString(3, (String) userInfo.get("lastName"));
				LocalDate dob = (LocalDate) userInfo.get("dob");
			    java.sql.Date sqlDob = java.sql.Date.valueOf(dob);
			    st.setDate(4, sqlDob);
				st.setString(5, (String) userInfo.get("gender"));
				st.setString(6, (String) userInfo.get("email"));
				st.setString(7, (String) userInfo.get("phoneNumber"));
				st.setString(8, (String) userInfo.get("address"));
				st.setString(9, (String) userInfo.get("username"));
				int result = st.executeUpdate();
				System.out.println(result);
	            return result > 0 ? 1 : 0;
			}
			catch(Exception e) {
				e.printStackTrace();
				return -1;
			}
		}
		
		public int checkOut(int cartID, LocalDate date, String orderStatus, double price) {
			try(Connection con = getConnection()){
				PreparedStatement st = con.prepareStatement(StringUtils.ADD_ORDER);
				st.setInt(1, cartID);
				java.sql.Date sqlDob = java.sql.Date.valueOf(date);
				st.setDate(2, sqlDob);
				st.setString(3, orderStatus);
				st.setDouble(4, price);
				int result = st.executeUpdate();
	            return result > 0 ? 1 : 0;
			}
			catch(Exception e) {
				e.printStackTrace();
				return -1;
			}
		}
		
		public  Map<Integer, Map<String, Object>>  recentOrders() {
			 Map<Integer, Map<String, Object>> orderMap = new LinkedHashMap<>();
			
		    try (Connection connection = getConnection()){
		         PreparedStatement statement = connection.prepareStatement(StringUtils.RECENT_ORDER); 
		        
		        try (ResultSet rs = statement.executeQuery()) {
		            while (rs.next()) {
		                Map<String, Object> row = new HashMap<>();
		                row.put("Product_Image", rs.getString("Product_Image"));
		                row.put("Product_Name", rs.getString("Product_Name"));
		                row.put("Price", rs.getDouble("Price"));
		                row.put("Quantity", rs.getInt("Quantity"));
		                row.put("Product_Description", rs.getString("Product_Description"));
		                
		                int productId = rs.getInt("Product_ID");
		    			orderMap.put(productId, row);
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return orderMap;
		}
		
		public  Map<Integer, Map<String, Object>>  recentOrdersAdmin() {
			 Map<Integer, Map<String, Object>> orderMap = new LinkedHashMap<>();
			 try (Connection connection = getConnection()){
			 PreparedStatement statement = connection.prepareStatement(StringUtils.ALL_ORDER_ADMIN);
			 int i =0;
			 try (ResultSet rs = statement.executeQuery()) {
		            while (rs.next()) {
		                Map<String, Object> row = new HashMap<>();
		                row.put("OrderID", rs.getInt("OrderID"));
		                row.put("CartID", rs.getInt("CartID"));
		                row.put("OrderStatus", rs.getString("OrderStatus"));
		                row.put("OrderDate", rs.getDate("OrderDate"));
		                row.put("ProductID", rs.getInt("ProductID"));
		                row.put("Quantity", rs.getInt("Quantity"));
		                row.put("ProductName", rs.getString("ProductName"));
		                row.put("ProductDescription", rs.getString("ProductDescription"));
		                row.put("ProductPrice", rs.getDouble("ProductPrice"));
		                row.put("ProductStock", rs.getInt("ProductStock"));		
		                i= i+1;
		                orderMap.put(i, row);
		                System.out.println(orderMap);
		            }
		            //System.out.println(orderMap);
			 }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return orderMap;
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public int check_role(String role) {
		try(Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement(StringUtils.CHECK_ROLE);
			if (role=="user"){
					return 1;
			}
			else {
				return 2; 
			}
		}
		catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	public int getLoginInfo(String username, String password) {
		try(Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement(StringUtils.GET_LOGIN_USER_INFO);
			st.setString(1, username);
            st.setString(2, password);
            int result = st.executeUpdate();
            System.out.println(result);
            return result > 0 ? 1 : 0;
		}
		catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	public void role(String user_name) {
		try(Connection con = getConnection();) {
			PreparedStatement st = con.prepareStatement(StringUtils.CHECK_ROLE);
			st.setString(1, user_name);
			ResultSet rs = st.executeQuery();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	

