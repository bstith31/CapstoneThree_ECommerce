package org.yearup.data;


import org.yearup.models.Profile;

public interface ProfileDao
{
    Profile create(Profile profile);
    Profile getByUserId(int userId);
    //could include int userId in signature
    void update(Profile profile);
    //could add a delete method as well
}
