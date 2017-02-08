/**
 * Teknei 2016
 */
package com.teknei.service.assembler;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;

import lombok.SneakyThrows;

/**
 * Utility class for transform Entities into DTOs
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <D> - DTO class
 * @param <E> - Entity class
 */
public class Assembler<D, E> {

	private static final Logger log = LoggerFactory.getLogger(Assembler.class);
	
	private Class<D> typeDTO;
	private Class<E> typeEntity;
	
	public Assembler(Class<D> clazzDTO, Class<E> clazzEntity) {
		this.typeDTO = clazzDTO;
		this.typeEntity = clazzEntity;
	}

	/**
	 * Transform Entity object into DTO object
	 * @param e - Entity object
	 * @return DTO object
	 * @throws RuntimeException - If any error ocurrs
	 */
	@SneakyThrows
	public D getDTO(E e) {
		Class clazzD = typeDTO;
		D d = (D) clazzD.newInstance();
		Field[] fields = e.getClass().getDeclaredFields();
		PropertyAccessor accessorDTO = PropertyAccessorFactory.forBeanPropertyAccess(d);
		PropertyAccessor accesorEntity = PropertyAccessorFactory.forBeanPropertyAccess(e);
		for (Field fieldsEntity : fields) {
			try {
				String name = fieldsEntity.getName();
				if (name.equals("serialVersionUID")) {
					continue;
				}
				Object value = accesorEntity.getPropertyValue(name);
				if (name.equals("pk")) {
					Field[] fieldsPK = value.getClass().getDeclaredFields();
					PropertyAccessor accessorPK = PropertyAccessorFactory.forBeanPropertyAccess(value);
					for (Field fieldPK : fieldsPK) {
						try {
							String namePK = fieldPK.getName();
							if (namePK.equals("serialVersionUID")) {
								continue;
							}
							Object valuePK = accessorPK.getPropertyValue(namePK);
							accessorDTO.setPropertyValue(namePK, valuePK);
						} catch (InvalidPropertyException ie) {
							log.error("Error: {}", ie.getMessage());
						}
					}
				} else {
					accessorDTO.setPropertyValue(name, value);
				}
			} catch (InvalidPropertyException ie) {
				log.error("Error: {}", ie.getMessage());
			}
		}
		return d;
	}


}
