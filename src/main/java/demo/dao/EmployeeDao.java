/*
 *  Copyright (c) 2004-2015 乐视网（letv.com）. All rights reserved
 * 
 *  LETV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 */

package demo.dao;

import demo.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author <a href="mailto:pizhigang@letv.com">pizhigang</a>
 */
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {

}
