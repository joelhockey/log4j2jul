/*
 *   Copyright 2011 Joel Hockey (joel.hockey@gmail.come)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.apache.log4j;

import java.util.logging.Level;

/**
 * Simpler than commons-logging or slf4j.
 *
 * Wraps java.util.logging.Logger in org.apache.commons.logging.Logger.
 *
 * This allows you to write logging code using log4j and switch to
 * java.util.logging if you ever need to - probably never.
 *
 * @author Joel Hockey
 */
public class Logger {
    private java.util.logging.Logger l;
    private Logger(java.util.logging.Logger logger) { this.l = logger; }
    public static Logger getLogger(Class clazz) { return getLogger(clazz.getName()); }
    public static Logger getLogger(String name) { return new Logger(java.util.logging.Logger.getLogger(name)); }
    public static Logger getRootLogger() { return new Logger(java.util.logging.Logger.global); }

    public String getName() { return l.getName(); }
    public void debug(Object o) { if (l.isLoggable(Level.FINE)) l.log(Level.FINE, o.toString()); }
    public void debug(Object o, Throwable t) { if (l.isLoggable(Level.FINE)) l.log(Level.FINE, o.toString(), t); }
    public void error(Object o) { if (l.isLoggable(Level.SEVERE)) l.log(Level.SEVERE, o.toString()); }
    public void error(Object o, Throwable t) { if (l.isLoggable(Level.SEVERE)) l.log(Level.SEVERE, o.toString(), t); }
    public void fatal(Object o) { if (l.isLoggable(Level.SEVERE)) l.log(Level.SEVERE, o.toString()); }
    public void fatal(Object o, Throwable t) { if (l.isLoggable(Level.SEVERE)) l.log(Level.SEVERE, o.toString(), t); }
    public void info(Object o) { if (l.isLoggable(Level.INFO)) l.log(Level.INFO, o.toString()); }
    public void info(Object o, Throwable t) { if (l.isLoggable(Level.INFO)) l.log(Level.INFO, o.toString(), t); }
    public boolean isDebugEnabled() { return l.isLoggable(Level.FINE); }
    public boolean isErrorEnabled() { return l.isLoggable(Level.SEVERE); }
    public boolean isFatalEnabled() { return l.isLoggable(Level.SEVERE); }
    public boolean isInfoEnabled() { return l.isLoggable(Level.INFO); }
    public boolean isTraceEnabled() { return l.isLoggable(Level.FINEST); }
    public boolean isWarnEnabled() { return l.isLoggable(Level.WARNING); }
    public void trace(Object o) { if (l.isLoggable(Level.FINEST)) l.log(Level.FINEST, o.toString()); }
    public void trace(Object o, Throwable t) { if (l.isLoggable(Level.FINEST)) l.log(Level.FINEST, o.toString(), t); }
    public void warn(Object o) { if (l.isLoggable(Level.WARNING)) l.log(Level.WARNING, o.toString()); }
    public void warn(Object o, Throwable t) { if (l.isLoggable(Level.WARNING)) l.log(Level.WARNING, o.toString(), t); }
}
