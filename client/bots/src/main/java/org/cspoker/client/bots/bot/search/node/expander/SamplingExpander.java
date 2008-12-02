/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.client.bots.bot.search.node.expander;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.cspoker.client.bots.bot.search.action.EvaluatedAction;
import org.cspoker.client.bots.bot.search.action.ProbabilityAction;
import org.cspoker.client.bots.bot.search.action.SampledAction;
import org.cspoker.client.bots.bot.search.node.BotActionNode;
import org.cspoker.client.bots.bot.search.node.InnerGameTreeNode;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multiset.Entry;

public class SamplingExpander extends Expander{

	private final static Logger logger = Logger.getLogger(BotActionNode.class);

	public final static int samples = 8;

	private final Random random = new Random();

	public SamplingExpander(InnerGameTreeNode node) {
		super(node);
	}

	public Set<? extends EvaluatedAction<? extends SampledAction>> expand(){
		List<SampledAction> sampledActions = sampleActions();
		Set<EvaluatedAction<SampledAction>> evaluatedActions = new HashSet<EvaluatedAction<SampledAction>>(sampledActions.size());
		for(SampledAction sampledAction:sampledActions){
			evaluatedActions.add(node.expandWith(sampledAction));
		}
		return evaluatedActions;
	}

	private List<SampledAction> sampleActions() {
		List<ProbabilityAction> probActions = new ArrayList<ProbabilityAction>(node.getProbabilityActions());
		double[] cumulProb = new double[probActions.size()];

		for(int i=0;i<probActions.size();i++){
			cumulProb[i] = (i>0?cumulProb[i-1]:0)+probActions.get(i).getProbability();
		}
		if(logger.isTraceEnabled()){
			for(int i=0;i<probActions.size();i++){
				logger.trace("cumulProb["+i+"]="+cumulProb[i] +" for action "+probActions.get(i));

			}
		}


		Multiset<ProbabilityAction> samples = Multisets.newHashMultiset();
		for(int i=0;i<SamplingExpander.samples;i++){
			samples.add(sampleAction(probActions, cumulProb));
		}

		Set<Entry<ProbabilityAction>> entrySet = samples.entrySet();
		List<SampledAction> sampledActions = new ArrayList<SampledAction>(entrySet.size());
		for(Entry<ProbabilityAction> entry:entrySet){
			sampledActions.add(new SampledAction(entry.getElement(), entry.getCount(), SamplingExpander.samples));
		}
		return sampledActions;
	}

	private ProbabilityAction sampleAction(List<ProbabilityAction> probActions,
			double[] cumulProb) {
		double randDouble = random.nextDouble();
		for(int i=0;i<cumulProb.length;i++){
			if(randDouble<cumulProb[i]){
				if(logger.isTraceEnabled()){
					logger.trace("random "+randDouble+" assigned to "+probActions.get(i));
				}
				return probActions.get(i);
			}
		}
		return probActions.get(probActions.size()-1);
	}
}
