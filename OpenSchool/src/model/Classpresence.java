package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the classpresence database table.
 * 
 */
@Entity
@NamedQuery(name="Classpresence.findAll", query="SELECT c FROM Classpresence c")
public class Classpresence implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClasspresencePK id;

	private byte isPresent;

	public Classpresence() {
	}

	public ClasspresencePK getId() {
		return this.id;
	}

	public void setId(ClasspresencePK id) {
		this.id = id;
	}

	public byte getIsPresent() {
		return this.isPresent;
	}

	public void setIsPresent(byte isPresent) {
		this.isPresent = isPresent;
	}

}