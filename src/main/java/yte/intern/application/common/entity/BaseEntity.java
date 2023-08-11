package yte.intern.application.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@MappedSuperclass //inherit edilen her şeyi yansıtır, kendisi asıl  entity değildir
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version // soft locking, default olarak sıfırdan başlar, satırlarda değişiklik yapıldığında değeri 1 artar
    private Long version;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate  // entity oluşturulduğundaki saatleri logda görmek için lazım ve değişikliklerin kimler tarafından yapıldığını görmek için
    private LocalDateTime lastModifiedDate;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof HibernateProxy) {
            obj = ((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation();
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseEntity other = (BaseEntity) obj;
        if (this.id == null) {
            return false;
        } else {
            return this.id.equals(other.id);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
