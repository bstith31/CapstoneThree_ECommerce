package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.models.Profile;
import org.yearup.data.ProfileDao;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class MySqlProfileDao extends MySqlDaoBase implements ProfileDao
{
    public MySqlProfileDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public Profile create(Profile profile)
    {
        String sql = "INSERT INTO profiles (user_id, first_name, last_name, " +
                "phone, email, address, city, state, zip) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, profile.getUserId());
            ps.setString(2, profile.getFirstName());
            ps.setString(3, profile.getLastName());
            ps.setString(4, profile.getPhone());
            ps.setString(5, profile.getEmail());
            ps.setString(6, profile.getAddress());
            ps.setString(7, profile.getCity());
            ps.setString(8, profile.getState());
            ps.setString(9, profile.getZip());

            ps.executeUpdate();

            return profile;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    //Methods may be restructured to match create
    @Override
    public Profile getByUserId(int userId) {

        String sql = "SELECT * FROM profiles WHERE user_id = ?";

        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return mapRow(resultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   // @Override
   // public void update(int userId, Profile profile) {

    }

    }

    @Override
    public void update(Profile profile) {

        String sql = "UPDATE profiles SET first_name = ?, last_name = ?, phone = ?, " +
                "email = ?, address = ?, city = ?, state = ?, zip = ?" +
                "WHERE user_id = ?";

        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, profile.getFirstName());
            preparedStatement.setString(2, profile.getLastName());
            preparedStatement.setString(3, profile.getPhone());
            preparedStatement.setString(4, profile.getEmail());
            preparedStatement.setString(5, profile.getAddress());
            preparedStatement.setString(6, profile.getCity());
            preparedStatement.setString(7, profile.getState());
            preparedStatement.setString(8, profile.getZip());
            preparedStatement.setInt(9, profile.getUserId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Profile mapRow(ResultSet resultSet) throws SQLException {
        Profile profile = new Profile();
        profile.setUserId(resultSet.getInt("user_id"));
        profile.setFirstName(resultSet.getString("first_name"));
        profile.setLastName(resultSet.getString("last_name"));
        profile.setPhone(resultSet.getString("phone"));
        profile.setEmail(resultSet.getString("email"));
        profile.setAddress(resultSet.getString("address"));
        profile.setCity(resultSet.getString("city"));
        profile.setState(resultSet.getString("state"));
        profile.setZip(resultSet.getString("zip"));
        return profile;
    }



}
