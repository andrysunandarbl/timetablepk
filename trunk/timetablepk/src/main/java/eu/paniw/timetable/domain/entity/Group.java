package eu.paniw.timetable.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="GroupUnit")
public class Group extends UnitDef {
	private static final long serialVersionUID = -3345478728835769666L;
}
