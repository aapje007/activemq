/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.store.kahadb.scheduler;

import org.apache.activemq.broker.scheduler.Job;
import org.apache.activemq.broker.scheduler.JobSupport;
import org.apache.activemq.util.ByteSequence;


public class JobImpl implements Job {
    private final JobLocation jobLocation;
    private final byte[] payload;
    
    protected JobImpl(JobLocation location,ByteSequence bs) {
        this.jobLocation=location;
        this.payload = new byte[bs.getLength()];
        System.arraycopy(bs.getData(), bs.getOffset(), this.payload, 0, bs.getLength());
    }

    public String getJobId() {
        return this.jobLocation.getJobId();
    }

    public byte[] getPayload() {
       return this.payload;
    }

    public long getPeriod() {
       return this.jobLocation.getPeriod();
    }

    public int getRepeat() {
       return this.jobLocation.getRepeat();
    }

    public long getStart() {
       return this.jobLocation.getStartTime();
    }
    
    public long getDelay() {
        return this.jobLocation.getDelay();
    }

    public String getCronEntry() {
        return this.jobLocation.getCronEntry();
    }
    
    

    public String getNextExecutionTime() {
        return JobSupport.getDateTime(this.jobLocation.getNextTime());
    }

    public String getStartTime() {
        return JobSupport.getDateTime(getStart());
    }


}
