#Licensed to the Apache Software Foundation (ASF) under one
#or more contributor license agreements.  See the NOTICE file
#distributed with this work for additional information
#regarding copyright ownership.  The ASF licenses this file
#to you under the Apache License, Version 2.0 (the
#"License"); you may not use this file except in compliance
#with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
#Unless required by applicable law or agreed to in writing,
#software distributed under the License is distributed on an
#"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
#KIND, either express or implied.  See the License for the
#specific language governing permissions and limitations
#under the License.

import os, sys, time
import simplejson as json
from zohmg.config import Config

# add middleware dir and import data_utils.
sys.path.append(os.path.dirname(__file__))
import data_utils


class data(object):
    def __init__(self):
        self.config = Config()
        self.table = self.config.dataset()
        self.projections = self.config.projections()

    # example query:
    # ?t0=20090120&t1=20090121&unit=pageviews&d0=country&d0v=US,DE
    def __call__(self, environ, start_response):
        print "[%s] Data, serving from table: %s." % (time.asctime(),self.table)

        # fetch data.
        start = time.time()
        try: data = data_utils.hbase_get(self.table, self.projections, environ) # query is in environ.
        except ValueError:
            print >>sys.stderr, "Error: Could not parse query."
            start_response('200 OK', [('content-type', 'text/html')]) # TODO: not 200.
            return "could not parse query." # TODO: nicer.
        except:
            print >>sys.stderr, "Error: unknown error :-("
            start_response('500 OK', [('content-type', 'text/html')])
            return "egads!" # TODO: nicer.

        elapsed = (time.time() - start)
        sys.stderr.write("hbase query+prep time: %s\n" % elapsed)

        # serve output.
        # TODO: it's hardly html, now is it?
        start_response('200 OK', [('content-type', 'text/html')])
        return data_utils.dump_jsonp(data)
        #"jsonZohmgFeed(" + json.dumps(data) + ")" # jsonp.
