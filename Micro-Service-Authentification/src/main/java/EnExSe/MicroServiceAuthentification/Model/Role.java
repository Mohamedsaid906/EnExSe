package EnExSe.MicroServiceAuthentification.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role implements Serializable {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long role_id;

        private String role;


}
