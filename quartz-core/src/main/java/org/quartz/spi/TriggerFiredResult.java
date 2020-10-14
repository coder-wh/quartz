package org.quartz.spi;

/**
 * @author lorban
 */
public class TriggerFiredResult {

  private TriggerFiredBundle triggerFiredBundle;

  //在通过trigger获取job时可能会发生异常, 若发生异常就将异常返回
  private Exception exception;

  public TriggerFiredResult(TriggerFiredBundle triggerFiredBundle) {
    this.triggerFiredBundle = triggerFiredBundle;
  }

  public TriggerFiredResult(Exception exception) {
    this.exception = exception;
  }

  public TriggerFiredBundle getTriggerFiredBundle() {
    return triggerFiredBundle;
  }

  public Exception getException() {
    return exception;
  }
}
