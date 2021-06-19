package com.leoncarraro.swing.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-06-19T12:43:19.771-0300")
@StaticMetamodel(Beer.class)
public class Beer_ {
	public static volatile SingularAttribute<Beer, Long> id;
	public static volatile SingularAttribute<Beer, String> sku;
	public static volatile SingularAttribute<Beer, String> name;
	public static volatile SingularAttribute<Beer, String> description;
	public static volatile SingularAttribute<Beer, Integer> volume;
	public static volatile SingularAttribute<Beer, BigDecimal> value;
	public static volatile SingularAttribute<Beer, Integer> alcoholContent;
}
