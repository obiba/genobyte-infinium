/*******************************************************************************
 * Copyright 2007(c) Genome Quebec. All rights reserved.
 * 
 * This file is part of GenoByte.
 * 
 * GenoByte is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 * 
 * GenoByte is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 *******************************************************************************/
package org.obiba.illumina.bitwise.model;

import org.obiba.bitwise.annotation.AnnotationStoreSchemaBuilder;
import org.obiba.bitwise.schema.FieldMetaData;
import org.obiba.bitwise.schema.StoreSchema;

import junit.framework.TestCase;

public class AssayModelTest extends TestCase {

  public void testAnnotationSchema() {
    AnnotationStoreSchemaBuilder builder = new AnnotationStoreSchemaBuilder();
    try {
      StoreSchema schema = builder.createSchema(Assay.class);
      FieldMetaData fmd = schema.getField("calls_1234");
      assertNotNull(fmd);
    } catch(Exception e) {
      fail(e.getMessage());
    }
  }
}
