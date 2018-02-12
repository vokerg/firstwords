package com.dgr.firstwords.manager;

public class QuestionStrategyFactory {
	public static enum Strategies {
		DEFAULT(QuestionStrategyDefault.class);
		
		private Class<? extends QuestionStrategy> strategyClass;
		
		Strategies(Class<? extends QuestionStrategy> strategyClass) {
			this.strategyClass = strategyClass;
		}
		
		Class<? extends QuestionStrategy> getStrategyClass() {
			return strategyClass;
		}
	}
	
	public QuestionStrategy getStrategyInstance(String code) throws InstantiationException, IllegalAccessException {
		return Strategies.DEFAULT.getStrategyClass().newInstance();
	}

}
