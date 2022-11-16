package com.castletroymedical.database;

import com.castletroymedical.database.data.PatientDTO;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTest {
    super(repo,entityManager);
    @Autowired
    private UserRepo repo;

    @Autowired
    private TestEntityManager entityManager;

    public boolean login(String email, String password) {
        // account verification, exception handling
        return true;
    }

    // view details

    public void updatePatientAddress(PatientDTO p, String address) {
        p.setAddress(address);

    }

    public void updatePatientName(PatientDTO p, String name) {
        p.setName(name);
    }

    public void updatePatientEmail(PatientDTO p, String email) {
        p.setEmail(email);
    }

    public void updatePatientNumber(PatientDTO p, int number) {
        p.setPhoneNumber(number);
    }

    public void updatePatientMedicalCardStatus(PatientDTO p, boolean status) {
        p.setMedicalCardHolder(status);
    }

    public void updatePatientInsuranceStatus(PatientDTO p, boolean insurance) {
        p.setMedicalCardHolder(insurance);
    }

    public void testCreateUser() {
        User user = new User();
        user.setEmail("applebaum@hotmail.com");
        user.setName("Apple Baum");
        user.setPassword("Asd123");
        user.setAddress("Apple Blossom St, Whale Ave");
        user.setPpsn("9876542BA");
        user.setPhoneNumber(846288476);
        user.setMedicalCardHolder(false);
        user.setInsured(true);

        User saveduser = repo.save(user);

        User existinguser = entityManager.find(User.class, saveduser.getId());

        assertThat(existinguser.getEmail()).isEqualTo(user.getEmail());
    }

}
