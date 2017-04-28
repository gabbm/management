package tech.gab.web.management.project_management.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tech.gab.web.management.project_management.entities.Property;
import tech.gab.web.management.project_management.exceptions.PropertyNotFoundException;
import tech.gab.web.management.project_management.repositories.PropertyRepository;
import tech.gab.web.management.project_management.services.PropertyService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PropertyServiceImpl implements PropertyService{

	private static final Log log = LogFactory.getLog(PropertyServiceImpl.class);
	
	private PropertyRepository propertyRepository;
	
	@Autowired
	public PropertyServiceImpl(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}

	@Override
	public String getValue(String name, Object defaultValue) throws PropertyNotFoundException{
		Property property = propertyRepository.findByName(name);
		String value = null;
		
		if(property != null){
			value = property.getValue();
		}else{
			if(defaultValue == null){
				throw new PropertyNotFoundException(name);
			}else{
				value = defaultValue.toString();
			}
		}

		return value;
	}

}
